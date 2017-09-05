package sasd97.java_blog.xyz.lib_router.commands;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by alexander on 06/09/2017.
 */

public class With extends ActivityCommand {

    private Bundle bundle;

    public With(@NonNull Bundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public void apply(@NonNull Activity activity, @NonNull Intent intent) {
        intent.putExtras(bundle);
    }
}
