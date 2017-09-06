
package sasd97.java_blog.xyz.lib_router.commands.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import sasd97.java_blog.xyz.lib_router.commands.providers.ProviderCommand;

/**
 * Created by alexander on 06/09/2017.
 */

public final class StartForResult extends ActivityCommand {

    private Class<?> to;
    private int requestCode;
    private ProviderCommand<Bundle> command;

    public StartForResult(@NonNull Class<?> to,
                          int requestCode) {
        this.to = to;
        this.requestCode = requestCode;
    }

    public StartForResult(@NonNull Class<?> to,
                          int requestCode,
                          @NonNull ProviderCommand<Bundle> command) {
        this.to = to;
        this.command = command;
        this.requestCode = requestCode;
    }

    @Override
    public void apply(@NonNull Activity activity) {
        Intent startIntent = new Intent(activity, to);
        if (command != null) startIntent.putExtras(command.getContent(null));
        activity.startActivityForResult(startIntent, requestCode);
    }
}
