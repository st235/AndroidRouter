// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.commands.activities;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.github.sasd97.lib_router.commands.CommandDecorator;

public abstract class ActivityCommand extends CommandDecorator<ActivityCommand> {

    protected ActivityCommand() {
    }

    protected ActivityCommand(@NonNull ActivityCommand command) {
        super(command);
    }

    public abstract void apply(@NonNull Activity activity);
}
