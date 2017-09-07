package com.github.sasd97.lib_router.exceptions;

/**
 * Created by alexander on 07/09/2017.
 */

public class SatelliteNotAttachedException extends RuntimeException {

    public SatelliteNotAttachedException() {
        super("There is no active satellite attached to router");
    }
}
