package sasd97.java_blog.xyz.lib_router.commands;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * Created by alexander on 06/09/2017.
 */

public class And extends ActivityCommand {

    public And(@NonNull ActivityCommand command) {
        super(command);
    }

    @Override
    public void apply(@NonNull Activity activity,
                      @NonNull Intent intent) {
        wrappedCommand.apply(activity, intent);
    }
}
