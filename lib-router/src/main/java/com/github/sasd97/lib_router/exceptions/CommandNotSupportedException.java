// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.exceptions;

import android.support.annotation.NonNull;

import java.util.Locale;

/**
 * Throws when satellite try to execute command, which is not applicable to it.
 */
public final class CommandNotSupportedException extends RuntimeException {

    public CommandNotSupportedException(@NonNull String group) {
        super(
                String.format(Locale.US, "Your type is not supported. Command must follow \'%1$s\' group.", group)
        );
    }
}
