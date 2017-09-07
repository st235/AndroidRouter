package com.github.sasd97.lib_router.commands.fragments;

import android.support.annotation.AnimRes;
import android.support.annotation.AnimatorRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by alexander on 07/09/2017.
 */

public class WithCustomAnimation extends FragmentCommand {

    private int startAnimation;
    private int endAnimation;

    public WithCustomAnimation(@AnimatorRes @AnimRes int startAnimation,
                               @AnimatorRes @AnimRes int endAnimation,
                               @NonNull FragmentCommand command) {
        super(command);
        this.startAnimation = startAnimation;
        this.endAnimation = endAnimation;
    }

    @Override
    public FragmentTransaction apply(int containerId, @NonNull FragmentTransaction transaction) {
        FragmentTransaction t = transaction.setCustomAnimations(startAnimation, endAnimation);
        return command.apply(containerId, t);
    }
}
