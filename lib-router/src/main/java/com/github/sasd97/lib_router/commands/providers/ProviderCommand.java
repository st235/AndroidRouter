// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.commands.providers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.sasd97.lib_router.commands.CommandDecorator;

/**
 * Command which is not navigation, but provides data between navigation frames.
 * @param <T> data type.
 */
public abstract class ProviderCommand<T> extends CommandDecorator<ProviderCommand<T>> {

    protected ProviderCommand() { /* default constructor */ }

    protected ProviderCommand(@NonNull ProviderCommand<T> command) {
        super(command);
    }

    public abstract T getContent(@Nullable T content);
}
