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

public class SecondaryActivity extends AppCompatActivity {

    private Router router = new BaseRouter();
    private Satellite satellite = new FragmentSatellite(R.id.fragmentContainer, getSupportFragmentManager());

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    router.pushCommand(
                            new Replace(new FirstFragment(), null, new And(new AddToBackStack(null)))
                    );
                    return true;
                case R.id.navigation_dashboard:
                    router.pushCommand(
                            new Replace(new SecondFragment(), "tag")
                    );
                    return true;
                case R.id.navigation_notifications:
                    router.pushCommand(
                            new WithCustomAnimation(R.anim.slide_in, R.anim.slide_out, new Replace(new ThirdFragment(), null))
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

        router.attachSatellite(satellite);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Intent intent = getIntent();
        Bundle args = intent.getExtras();

        if (args != null && args.containsKey("args")) {
            Toast.makeText(this, String.valueOf(args.getInt("args")), Toast.LENGTH_LONG).show();
        }
    }
}
