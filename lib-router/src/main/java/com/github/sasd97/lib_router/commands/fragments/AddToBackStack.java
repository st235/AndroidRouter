package com.github.sasd97.lib_router.commands.fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by alexander on 06/09/2017.
 */

public class AddToBackStack extends FragmentCommand {

    private String tag;

    public AddToBackStack(@Nullable String tag) {
        this.tag = tag;
    }

    @Override
    public FragmentTransaction apply(int containerId, @NonNull FragmentTransaction transaction) {
        return transaction.addToBackStack(tag);
    }
}
