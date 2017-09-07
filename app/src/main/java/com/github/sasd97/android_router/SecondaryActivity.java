package com.github.sasd97.android_router;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.sasd97.lib_router.BaseRouter;
import com.github.sasd97.lib_router.Router;
import com.github.sasd97.lib_router.commands.fragments.AddToBackStack;
import com.github.sasd97.lib_router.commands.fragments.And;
import com.github.sasd97.lib_router.commands.fragments.Replace;
import com.github.sasd97.lib_router.commands.fragments.WithCustomAnimation;
import com.github.sasd97.lib_router.satellites.FragmentSatellite;
import com.github.sasd97.lib_router.satellites.Satellite;

import static com.github.sasd97.lib_router.commands.fragments.AddToBackStack.addToBackStack;
import static com.github.sasd97.lib_router.commands.fragments.And.and;
import static com.github.sasd97.lib_router.commands.fragments.Replace.replace;
import static com.github.sasd97.lib_router.commands.fragments.WithCustomAnimation.animate;
import static com.github.sasd97.lib_router.commands.messages.ShowToast.showToast;

public class SecondaryActivity extends AppCompatActivity {

    private Router router = new BaseRouter();
    private Satellite satellite;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    router.pushCommand(replace(new FirstFragment(), null, and(addToBackStack(null))));
                    return true;
                case R.id.navigation_dashboard:
                    router.pushCommand(replace(new SecondFragment(), "tag"));
                    return true;
                case R.id.navigation_notifications:
                    router.pushCommand(
                            animate(R.anim.slide_in, R.anim.slide_out, replace(new ThirdFragment(), null))
                    );
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        satellite = new FragmentSatellite(R.id.fragmentContainer,
                getApplicationContext(), getSupportFragmentManager());
        router.attachSatellite(satellite);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Intent intent = getIntent();
        Bundle args = intent.getExtras();

        if (args != null && args.containsKey("args")) {
            router.pushCommand(showToast(Toast.LENGTH_SHORT, String.valueOf(args.getInt("args"))));
        }
    }
}
