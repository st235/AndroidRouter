package sasd97.java_blog.xyz.lib_router.commands.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * Created by alexander on 06/09/2017.
 */

public final class FinishThis extends ActivityCommand {

    public FinishThis(@NonNull ActivityCommand command) {
        super(command);
    }

    @Override
    public void apply(@NonNull Activity activity) {
        command.apply(activity);
        activity.finish();
    }
}
