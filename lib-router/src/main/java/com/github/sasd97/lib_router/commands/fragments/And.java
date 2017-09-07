package com.github.sasd97.lib_router.commands.fragments;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by alexander on 06/09/2017.
 */

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
