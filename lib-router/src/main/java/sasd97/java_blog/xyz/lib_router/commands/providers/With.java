package sasd97.java_blog.xyz.lib_router.commands.providers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by alexander on 06/09/2017.
 */

public final class With extends ProviderCommand<Bundle> {

    protected Bundle bundle;

    public With(@NonNull Bundle bundle) {
        this.bundle = bundle;
    }

    public With(@NonNull ProviderCommand<Bundle> command) {
        super(command);
    }

    @Override
    public Bundle getContent(@Nullable Bundle bundle) {
        if (this.bundle != null) return this.bundle;

        Bundle args = new Bundle();
        if (command != null) args = command.getContent(args);
        return args;
    }
}
