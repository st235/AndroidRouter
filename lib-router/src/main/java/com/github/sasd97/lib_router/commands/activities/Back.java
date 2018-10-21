package com.github.sasd97.lib_router.commands.activities;

import android.app.Activity;
import android.support.annotation.NonNull;

public class Back extends ActivityCommand {

    private Back() {
    }

    public static Back back() {
        return new Back();
    }

    @Override
    public void apply(@NonNull Activity activity) {
        activity.onBackPressed();
    }
}
