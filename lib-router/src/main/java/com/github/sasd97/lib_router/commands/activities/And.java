package com.github.sasd97.lib_router.commands.activities;

import android.app.Activity;
import android.support.annotation.NonNull;

/**
 * Created by alexander on 06/09/2017.
 */

public final class And extends ActivityCommand {

    private And(@NonNull ActivityCommand command) {
        super(command);
    }

    public static And and(@NonNull ActivityCommand command) {
        return new And(command);
    }

    @Override
    public void apply(@NonNull Activity activity) {
        command.apply(activity);
    }
}
