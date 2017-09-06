package com.github.sasd97.lib_router.satellites;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.github.sasd97.lib_router.commands.Command;
import com.github.sasd97.lib_router.commands.fragments.FragmentCommand;

/**
 * Created by alexander on 06/09/2017.
 */

public final class FragmentSatellite implements Satellite {

    private int containerId;
    private FragmentManager fragmentManager;

    public FragmentSatellite(int containerId,
                             @NonNull FragmentManager fragmentManager) {
        this.containerId = containerId;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void execute(@NonNull Command command) {
        if (!(command instanceof FragmentCommand)) return;

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction = ((FragmentCommand) command).apply(containerId, transaction);
        transaction.commit();
    }
}
