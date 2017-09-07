package com.github.sasd97.lib_router.satellites;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.github.sasd97.lib_router.commands.Command;
import com.github.sasd97.lib_router.commands.messages.Message;
import com.github.sasd97.lib_router.commands.messages.MessageCommand;

/**
 * Created by alexander on 07/09/2017.
 */

public class ToastSatellite implements Satellite {

    private Context context;

    public ToastSatellite(@NonNull Context context) {
        this.context = context;
    }

    @Override
    public void execute(@NonNull Command command) {
        Message message = ((MessageCommand) command).getMessage();
        Toast.makeText(context, message.getMessage(), message.getDuration()).show();
    }
}
