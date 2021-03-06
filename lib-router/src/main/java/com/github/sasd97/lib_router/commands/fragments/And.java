// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.s

package com.github.sasd97.lib_router.commands.fragments;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;

public class And extends FragmentCommand {

    private And(@NonNull FragmentCommand command) {
        super(command);
    }

    public static And and(@NonNull FragmentCommand command) {
        return new And(command);
    }

    @Override
    public FragmentTransaction apply(int containerId, @NonNull FragmentTransaction transaction) {
        return command.apply(containerId, transaction);
    }
}
