package com.github.sasd97.lib_router.commands.fragments;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;

import com.github.sasd97.lib_router.commands.CommandDecorator;

/**
 * Created by alexander on 06/09/2017.
 */

public abstract class FragmentCommand extends CommandDecorator<FragmentCommand> {

    public FragmentCommand() {
    }

    public FragmentCommand(@NonNull FragmentCommand command) {
        super(command);
    }

    public abstract FragmentTransaction apply(int containerId,
                                              @NonNull FragmentTransaction transaction);
}
