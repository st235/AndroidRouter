// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.commands.fragments;

import android.support.annotation.AnimRes;
import android.support.annotation.AnimatorRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;

public class WithCustomAnimation extends FragmentCommand {

    private int startAnimation;
    private int endAnimation;

    private WithCustomAnimation(@AnimatorRes @AnimRes int startAnimation,
                                @AnimatorRes @AnimRes int endAnimation,
                                @NonNull FragmentCommand command) {
        super(command);
        this.startAnimation = startAnimation;
        this.endAnimation = endAnimation;
    }

    public static WithCustomAnimation animate(@AnimatorRes @AnimRes int startAnimation,
                                              @AnimatorRes @AnimRes int endAnimation,
                                              @NonNull FragmentCommand command) {
        return new WithCustomAnimation(startAnimation, endAnimation, command);
    }

    @Override
    public FragmentTransaction apply(int containerId, @NonNull FragmentTransaction transaction) {
        FragmentTransaction t = transaction.setCustomAnimations(startAnimation, endAnimation);
        return command.apply(containerId, t);
    }
}
