// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.satellites;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.github.sasd97.lib_router.commands.Command;
import com.github.sasd97.lib_router.commands.fragments.FragmentCommand;
import com.github.sasd97.lib_router.exceptions.CommandNotSupportedException;

/**
 * Satellite which works with fragment stack.
 */
public final class FragmentSatellite implements Satellite {

    @IdRes
    private final int containerId;
    @NonNull
    private final FragmentManager fragmentManager;

    public FragmentSatellite(@IdRes int containerId,
                             @NonNull FragmentManager fragmentManager) {
        this.containerId = containerId;
        this.fragmentManager = fragmentManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getType() {
        return SatelliteTypes.FRAGMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(@NonNull Command command) {
        if (!isApplicable(command))
            throw new CommandNotSupportedException("Fragment group");

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction = ((FragmentCommand) command).apply(containerId, transaction);
        transaction.commit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isApplicable(@NonNull Command command) {
        return command instanceof FragmentCommand;
    }
}
