package com.github.sasd97.lib_router.commands.activities;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.github.sasd97.lib_router.commands.CommandDecorator;

/**
 * Created by alexander on 06/09/2017.
 */

public abstract class ActivityCommand extends CommandDecorator<ActivityCommand> {

    public ActivityCommand() {
    }

    public ActivityCommand(@NonNull ActivityCommand command) {
        super(command);
    }

    public abstract void apply(@NonNull Activity activity);
}
