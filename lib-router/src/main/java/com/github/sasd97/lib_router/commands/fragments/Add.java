package com.github.sasd97.lib_router.commands.fragments;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by alexander on 07/09/2017.
 */

public class Add extends FragmentCommand {

    private Fragment to;

    private Add(@NonNull Fragment to) {
        this.to = to;
    }

    private Add(@NonNull Fragment to,
                @NonNull FragmentCommand command) {
        super(command);
        this.to = to;
    }

    public static Add add(@NonNull Fragment to) {
        return new Add(to);
    }

    public static Add add(@NonNull Fragment to,
                          @NonNull FragmentCommand command) {
        return new Add(to, command);
    }

    @Override
    public FragmentTransaction apply(int containerId, @NonNull FragmentTransaction transaction) {
        FragmentTransaction t = transaction.add(containerId, to);
        return command == null ? t : command.apply(containerId, t);
    }
}
