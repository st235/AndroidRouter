package com.github.sasd97.lib_router.satellites;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.github.sasd97.lib_router.commands.Command;
import com.github.sasd97.lib_router.commands.fragments.FragmentCommand;
import com.github.sasd97.lib_router.commands.messages.MessageCommand;
import com.github.sasd97.lib_router.exceptions.CommandNotSupportedException;

/**
 * Created by alexander on 06/09/2017.
 */

public final class FragmentSatellite implements Satellite {

    private int containerId;
    private ToastSatellite toastSatellite;
    private FragmentManager fragmentManager;

    public FragmentSatellite(int containerId,
                             @NonNull Context context,
                             @NonNull FragmentManager fragmentManager) {
        this.containerId = containerId;
        this.fragmentManager = fragmentManager;
        this.toastSatellite = new ToastSatellite(context);
    }

    @Override
    public void execute(@NonNull Command command) {
        if (command instanceof MessageCommand) {
            toastSatellite.execute(command);
            return;
        }

        if (!(command instanceof FragmentCommand))
            throw new CommandNotSupportedException("Fragment Commands");

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction = ((FragmentCommand) command).apply(containerId, transaction);
        transaction.commit();
    }

    private void showSystemMessage(@NonNull MessageCommand messageCommand) {

    }
}
