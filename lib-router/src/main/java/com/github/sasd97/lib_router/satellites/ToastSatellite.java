// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.satellites;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.github.sasd97.lib_router.commands.Command;
import com.github.sasd97.lib_router.commands.messages.Message;
import com.github.sasd97.lib_router.commands.messages.MessageCommand;
import com.github.sasd97.lib_router.exceptions.CommandNotSupportedException;

/**
 * Satellite which handle toast messages commands.
 */
public class ToastSatellite implements Satellite {

    @NonNull
    private final Context context;

    public ToastSatellite(@NonNull Context context) {
        this.context = context;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getType() {
        return SatelliteTypes.TOAST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(@NonNull Command command) {
        if (!isApplicable(command))
            throw new CommandNotSupportedException("Message group");

        MessageCommand messageCommand = (MessageCommand) command;
        Message message = messageCommand.getMessage();
        Toast.makeText(context, message.getMessage(), message.getDuration()).show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isApplicable(@NonNull Command command) {
        return command instanceof MessageCommand;
    }
}
