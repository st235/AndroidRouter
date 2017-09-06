package sasd97.java_blog.xyz.lib_router.commands.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import sasd97.java_blog.xyz.lib_router.commands.Command;
import sasd97.java_blog.xyz.lib_router.commands.CommandDecorator;
import sasd97.java_blog.xyz.lib_router.commands.providers.ProviderCommand;

/**
 * Created by alexander on 06/09/2017.
 */

public abstract class ActivityCommand extends CommandDecorator<ActivityCommand> {

    public ActivityCommand() {
    }

    public ActivityCommand(@NonNull ActivityCommand command) {
        super(command);
    }

    public abstract void apply(@NonNull Activity activity);
}
