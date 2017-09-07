package com.github.sasd97.lib_router.exceptions;

import android.support.annotation.NonNull;

import java.util.Locale;

/**
 * Created by alexander on 06/09/2017.
 */

public final class CommandNotSupportedException extends RuntimeException {

    public CommandNotSupportedException(@NonNull String group) {
        super(
                String.format(Locale.US, "Your type is not supported. Command must follow \'%1$s\' group.", group)
        );
    }
}
