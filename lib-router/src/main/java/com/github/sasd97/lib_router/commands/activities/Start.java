package com.github.sasd97.lib_router.commands.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.github.sasd97.lib_router.commands.providers.ProviderCommand;

/**
 * Created by alexander on 06/09/2017.
 */

public final class Start extends ActivityCommand {

    private Class<?> to;
    private ProviderCommand<Bundle> command;

    private Start(@NonNull Class<?> to) {
        this.to = to;
    }

    private Start(@NonNull Class<?> to,
                  @NonNull ProviderCommand<Bundle> command) {
        this.to = to;
        this.command = command;
    }

    public static Start start(@NonNull Class<?> to) {
        return new Start(to);
    }

    public static Start start(@NonNull Class<?> to,
                              @NonNull ProviderCommand<Bundle> command) {
        return new Start(to, command);
    }


    @Override
    public void apply(@NonNull Activity activity) {
        Intent startIntent = new Intent(activity, to);
        if (command != null) startIntent.putExtras(command.getContent(null));
        activity.startActivity(startIntent);
    }
}
