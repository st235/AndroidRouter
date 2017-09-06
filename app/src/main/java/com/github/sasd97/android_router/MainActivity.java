package com.github.sasd97.android_router;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.sasd97.lib_router.BaseRouter;
import com.github.sasd97.lib_router.Router;
import com.github.sasd97.lib_router.commands.activities.And;
import com.github.sasd97.lib_router.commands.activities.FinishThis;
import com.github.sasd97.lib_router.commands.activities.Start;
import com.github.sasd97.lib_router.commands.providers.With;
import com.github.sasd97.lib_router.satellites.ActivitySatellite;
import com.github.sasd97.lib_router.satellites.Satellite;

public class MainActivity extends AppCompatActivity {

    private Router router = new BaseRouter();
    private Satellite satellite = new ActivitySatellite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        router.attachSatellite(satellite);

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                router.pushCommand(new Start(SecondaryActivity.class));
            }
        });

        findViewById(R.id.nextAndFinish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                router.pushCommand(new FinishThis(new And(new Start(SecondaryActivity.class))));
            }
        });

        findViewById(R.id.nextWithArgs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putInt("args", 1);
                router.pushCommand(new Start(SecondaryActivity.class, new With(args)));
            }
        });
    }
}
