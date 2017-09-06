package com.github.sasd97.lib_router.commands;

import android.support.annotation.NonNull;

/**
 * Created by alexander on 06/09/2017.
 */

public abstract class CommandDecorator<T extends Command> implements Command {

    protected T command;

    public CommandDecorator() {
    }

    public CommandDecorator(@NonNull T command) {
        this.command = command;
    }
}
