// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.commands.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

public final class ForwardIntent extends ActivityCommand {

    private final Intent intent;

    public ForwardIntent(@NonNull Intent intent) {
        this.intent = intent;
    }

    public static ForwardIntent forwardIntent(@NonNull Intent intent) {
        return new ForwardIntent(intent);
    }

    @Override
    public void apply(@NonNull Activity activity) {
        activity.startActivity(intent);
    }
}
