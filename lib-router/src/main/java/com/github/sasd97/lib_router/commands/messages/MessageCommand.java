package com.github.sasd97.lib_router.commands.messages;

import com.github.sasd97.lib_router.commands.Command;

/**
 * Created by alexander on 07/09/2017.
 */

public abstract class MessageCommand implements Command {
    public abstract Message getMessage();
}
