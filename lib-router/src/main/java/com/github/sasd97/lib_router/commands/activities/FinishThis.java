// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.commands.activities;

import android.app.Activity;
import android.support.annotation.NonNull;


public final class FinishThis extends ActivityCommand {

    private FinishThis() {
        super();
    }

    private FinishThis(@NonNull ActivityCommand command) {
        super(command);
    }

    public static FinishThis finishThis() {
        return new FinishThis();
    }

    public static FinishThis finishThis(@NonNull ActivityCommand command) {
        return new FinishThis(command);
    }

    @Override
    public void apply(@NonNull Activity activity) {
        if (command != null) command.apply(activity);
        activity.finish();
    }
}
