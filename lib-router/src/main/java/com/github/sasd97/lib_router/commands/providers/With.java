// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.commands.providers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Packs bundle data.
 */
public final class With extends ProviderCommand<Bundle> {

    @Nullable
    private final Bundle bundle;

    private With(@NonNull Bundle bundle) {
        this.bundle = bundle;
    }

    private With(@NonNull ProviderCommand<Bundle> command) {
        super(command);
        bundle = null;
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
