// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.satellites;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.github.sasd97.lib_router.commands.Command;
import com.github.sasd97.lib_router.commands.activities.ActivityCommand;
import com.github.sasd97.lib_router.exceptions.CommandNotSupportedException;

import java.lang.ref.WeakReference;

/**
 * Satellite which handle activity scope.
 */
public final class ActivitySatellite implements Satellite {

    private final WeakReference<Activity> activityReference;

    public ActivitySatellite(@NonNull Activity activity) {
        activityReference = new WeakReference<>(activity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getType() {
        return SatelliteTypes.ACTIVITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(@NonNull Command command) {
        if (!isApplicable(command))
            throw new CommandNotSupportedException("Activity group");

        Activity activity = activityReference.get();
        if (activity == null) return;
        ((ActivityCommand) command).apply(activity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isApplicable(@NonNull Command command) {
        return command instanceof ActivityCommand;
    }
}
