package com.github.sasd97.android_router;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.sasd97.lib_router.BaseRouter;
import com.github.sasd97.lib_router.Router;
import com.github.sasd97.lib_router.satellites.ActivitySatellite;
import com.github.sasd97.lib_router.satellites.Satellite;
import com.github.sasd97.lib_router.satellites.ToastSatellite;

import static com.github.sasd97.lib_router.commands.activities.And.and;
import static com.github.sasd97.lib_router.commands.activities.ForwardIntent.forwardIntent;
import static com.github.sasd97.lib_router.commands.activities.FinishThis.finishThis;
import static com.github.sasd97.lib_router.commands.activities.Start.start;
import static com.github.sasd97.lib_router.commands.activities.StartForResult.startForResult;
import static com.github.sasd97.lib_router.commands.messages.ShowToast.showToast;
import static com.github.sasd97.lib_router.commands.providers.With.with;

public class MainActivity extends AppCompatActivity {

    private Router router = new BaseRouter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        router.addSatellite(new ActivitySatellite(this));
        router.addSatellite(new ToastSatellite(this));

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                router.pushCommand(start(SecondaryActivity.class));
            }
        });

        findViewById(R.id.nextAndFinish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                router.pushCommand(finishThis(and(start(SecondaryActivity.class))));
            }
        });

        findViewById(R.id.nextWithArgs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putInt("args", 1);
                router.pushCommand(start(SecondaryActivity.class, with(args)));
            }
        });

        findViewById(R.id.showMessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                router.pushCommand(showToast(Toast.LENGTH_SHORT, "Hello world!"));
            }
        });

        findViewById(R.id.openGallery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                router.pushCommand(startForResult(openGallery, 1));
            }
        });

        findViewById(R.id.sendEmail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mail = new Intent(Intent.ACTION_SENDTO);
                mail.setData(Uri.parse("mailto:example@google.com?s=hello"));
                router.pushCommand(forwardIntent(Intent.createChooser(mail, "Choose email app")));
            }
        });
    }
}
