package sasd97.java_blog.xyz.android_router;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import sasd97.java_blog.xyz.lib_router.BaseRouter;
import sasd97.java_blog.xyz.lib_router.Router;
import sasd97.java_blog.xyz.lib_router.commands.And;
import sasd97.java_blog.xyz.lib_router.commands.FinishThis;
import sasd97.java_blog.xyz.lib_router.commands.Start;
import sasd97.java_blog.xyz.lib_router.satellites.ActivitySatellite;
import sasd97.java_blog.xyz.lib_router.satellites.Satellite;

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
    }
}
