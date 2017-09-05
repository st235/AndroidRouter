package sasd97.java_blog.xyz.lib_router.commands;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

/**
 * Created by alexander on 06/09/2017.
 */

public abstract class ActivityCommand implements Command {

    protected ActivityCommand wrappedCommand;

    protected ActivityCommand() {
    }

    protected ActivityCommand(@NonNull ActivityCommand command) {
        this.wrappedCommand = command;
    }

    public abstract void apply(@NonNull Activity activity,
                               @NonNull Intent intent);
}
