// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.exceptions;

/**
 * Throws when router cannot handle passed command by its satellites set.
 */
public class SatelliteNotAttachedException extends RuntimeException {

    public SatelliteNotAttachedException() {
        super("There is no active satellite attached to router");
    }
}
