// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.commands.fragments;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;

import com.github.sasd97.lib_router.commands.CommandDecorator;

public abstract class FragmentCommand extends CommandDecorator<FragmentCommand> {

    protected FragmentCommand() {
    }

    protected FragmentCommand(@NonNull FragmentCommand command) {
        super(command);
    }

    public abstract FragmentTransaction apply(int containerId,
                                              @NonNull FragmentTransaction transaction);
}
