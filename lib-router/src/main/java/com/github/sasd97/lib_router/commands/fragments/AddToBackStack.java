package com.github.sasd97.lib_router.commands.fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by alexander on 06/09/2017.
 */

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
