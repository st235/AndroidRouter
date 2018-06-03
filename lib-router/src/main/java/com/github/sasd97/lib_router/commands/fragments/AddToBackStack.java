// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.commands.fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

public class AddToBackStack extends FragmentCommand {

    private String tag;

    private AddToBackStack(@Nullable String tag) {
        this.tag = tag;
    }

    public static AddToBackStack addToBackStack(@Nullable String tag) {
        return new AddToBackStack(tag);
    }

    @Override
    public FragmentTransaction apply(int containerId, @NonNull FragmentTransaction transaction) {
        return transaction.addToBackStack(tag);
    }
}
