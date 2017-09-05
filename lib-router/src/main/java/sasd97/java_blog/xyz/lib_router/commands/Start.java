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

    @Override
    public void apply(@NonNull Activity activity) {
        Intent intent = new Intent(activity, to);
        activity.startActivity(intent);
    }
}
