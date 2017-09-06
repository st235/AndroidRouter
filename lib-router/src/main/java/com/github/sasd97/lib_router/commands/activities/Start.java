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

    public Start(@NonNull Class<?> to) {
        this.to = to;
    }

    public Start(@NonNull Class<?> to,
                 @NonNull ProviderCommand<Bundle> command) {
        this.to = to;
        this.command = command;
    }

    @Override
    public void apply(@NonNull Activity activity) {
        Intent startIntent = new Intent(activity, to);
        if (command != null) startIntent.putExtras(command.getContent(null));
        activity.startActivity(startIntent);
    }
}
