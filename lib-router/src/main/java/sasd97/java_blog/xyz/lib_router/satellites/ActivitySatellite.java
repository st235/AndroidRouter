package sasd97.java_blog.xyz.lib_router.satellites;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.lang.ref.WeakReference;

import sasd97.java_blog.xyz.lib_router.commands.ActivityCommand;
import sasd97.java_blog.xyz.lib_router.commands.Command;

/**
 * Created by alexander on 06/09/2017.
 */

public class ActivitySatellite implements Satellite {

    private WeakReference<Activity> activityReference;

    public ActivitySatellite(@NonNull Activity activity) {
        activityReference = new WeakReference<>(activity);
    }

    @Override
    public void execute(@NonNull Command command) {
        Activity activity = activityReference.get();
        if (activity == null) return;
        ((ActivityCommand) command).apply(activity);
    }
}
