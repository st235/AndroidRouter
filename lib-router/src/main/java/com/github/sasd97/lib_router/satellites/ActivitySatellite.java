package com.github.sasd97.lib_router.satellites;

import android.app.Activity;
import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import com.github.sasd97.lib_router.commands.Command;
import com.github.sasd97.lib_router.commands.activities.ActivityCommand;
import com.github.sasd97.lib_router.commands.messages.MessageCommand;
import com.github.sasd97.lib_router.exceptions.CommandNotSupportedException;

/**
 * Created by alexander on 06/09/2017.
 */

public final class ActivitySatellite implements Satellite {

    private ToastSatellite toastSatellite;
    private WeakReference<Activity> activityReference;

    public ActivitySatellite(@NonNull Activity activity) {
        activityReference = new WeakReference<>(activity);
        toastSatellite = new ToastSatellite(activity.getApplicationContext());
    }

    @Override
    public void execute(@NonNull Command command) {
        if (command instanceof MessageCommand) {
            toastSatellite.execute(command);
            return;
        }

        if (!(command instanceof ActivityCommand))
            throw new CommandNotSupportedException("Activity Commands");

        Activity activity = activityReference.get();
        if (activity == null) return;
        ((ActivityCommand) command).apply(activity);
    }
}
