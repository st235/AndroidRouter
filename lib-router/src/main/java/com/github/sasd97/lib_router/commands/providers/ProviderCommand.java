package com.github.sasd97.lib_router.commands.providers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.sasd97.lib_router.commands.CommandDecorator;

/**
 * Created by alexander on 06/09/2017.
 */

public abstract class ProviderCommand<T> extends CommandDecorator<ProviderCommand<T>> {

    public ProviderCommand() {
    }

    public ProviderCommand(@NonNull ProviderCommand<T> command) {
        super(command);
    }

    public abstract T getContent(@Nullable T content);
}
