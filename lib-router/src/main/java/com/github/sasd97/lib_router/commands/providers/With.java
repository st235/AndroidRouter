package com.github.sasd97.lib_router.commands.providers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by alexander on 06/09/2017.
 */

public final class With extends ProviderCommand<Bundle> {

    protected Bundle bundle;

    private With(@NonNull Bundle bundle) {
        this.bundle = bundle;
    }

    private With(@NonNull ProviderCommand<Bundle> command) {
        super(command);
    }

    public static With with(@NonNull Bundle bundle) {
        return new With(bundle);
    }

    public static With with(@NonNull ProviderCommand<Bundle> command) {
        return new With(command);
    }

    @Override
    public Bundle getContent(@Nullable Bundle bundle) {
        if (this.bundle != null) return this.bundle;

        Bundle args = new Bundle();
        if (command != null) args = command.getContent(args);
        return args;
    }
}
