// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.commands.messages;

import com.github.sasd97.lib_router.commands.Command;

/**
 * System messages command.
 * Can provide messages.
 */
public abstract class MessageCommand implements Command {
    public abstract Message getMessage();
}
