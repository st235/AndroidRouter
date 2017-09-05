package sasd97.java_blog.xyz.lib_router.commands;

import android.app.Activity;
import android.support.annotation.NonNull;

/**
 * Created by alexander on 06/09/2017.
 */

public class FinishThis extends ActivityCommand {

    public FinishThis(@NonNull ActivityCommand command) {
        super(command);
    }

    @Override
    public void apply(@NonNull Activity activity) {
        wrappedCommand.apply(activity);
        activity.finish();
    }
}
