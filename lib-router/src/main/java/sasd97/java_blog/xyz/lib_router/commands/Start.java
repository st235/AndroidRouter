package sasd97.java_blog.xyz.lib_router.commands;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * Created by alexander on 06/09/2017.
 */

public class Start extends ActivityCommand {

    private Class<?> to;

    public Start(@NonNull Class<?> to) {
        this.to = to;
    }

    public Start(@NonNull Class<?> to,
                 @NonNull ActivityCommand command) {
        super(command);
        this.to = to;
    }

    @Override
    public void apply(@NonNull Activity activity,
                      @NonNull Intent intent) {
        Intent startIntent = new Intent(activity, to);
        if (wrappedCommand != null) wrappedCommand.apply(activity, startIntent);
        activity.startActivity(startIntent);
    }
}
