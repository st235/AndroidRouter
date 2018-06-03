// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.commands;

import android.support.annotation.NonNull;

/**
 * {@link Command} wrapper. Helps chain commands.
 * @param <T> command group.
 */
public abstract class CommandDecorator<T extends Command> implements Command {

    protected T command;

    protected CommandDecorator() {
    }

    public CommandDecorator(@NonNull T command) {
        this.command = command;
    }
}
