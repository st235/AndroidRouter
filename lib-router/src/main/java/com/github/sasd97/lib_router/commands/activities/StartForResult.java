
package com.github.sasd97.lib_router.commands.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.github.sasd97.lib_router.commands.providers.ProviderCommand;

/**
 * Created by alexander on 06/09/2017.
 */

public final class StartForResult extends ActivityCommand {

    private Class<?> to;
    private int requestCode;
    private Intent wrappedIntent;
    private ProviderCommand<Bundle> command;

    private StartForResult(@NonNull Class<?> to,
                           int requestCode) {
        this.to = to;
        this.requestCode = requestCode;
    }

    private StartForResult(@NonNull Class<?> to,
                           int requestCode,
                           @NonNull ProviderCommand<Bundle> command) {
        this.to = to;
        this.command = command;
        this.requestCode = requestCode;
    }

    private StartForResult(@NonNull Intent intent) {
        this.wrappedIntent = intent;
    }

    public static StartForResult startForResult(@NonNull Class<?> to,
                                                int requestCode) {
        return new StartForResult(to, requestCode);
    }

    public static StartForResult startForResult(@NonNull Class<?> to,
                                                int requestCode,
                                                @NonNull ProviderCommand<Bundle> command) {
        return new StartForResult(to, requestCode, command);
    }

    public static StartForResult startForResult(@NonNull Intent wrapped) {
        return new StartForResult(wrapped);
    }

    @Override
    public void apply(@NonNull Activity activity) {
         Intent startIntent = wrappedIntent != null ?
                 new Intent(wrappedIntent) : new Intent(activity, to);
        if (command != null) startIntent.putExtras(command.getContent(null));
        activity.startActivityForResult(startIntent, requestCode);
    }
}
