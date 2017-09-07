package com.github.sasd97.lib_router;

import android.support.annotation.NonNull;

import com.github.sasd97.lib_router.commands.Command;
import com.github.sasd97.lib_router.exceptions.SatelliteNotAttachedException;
import com.github.sasd97.lib_router.satellites.Satellite;

/**
 * Created by alexander on 06/09/2017.
 */

public class BaseRouter implements Router {

    private Satellite satellite;

    @Override
    public void pushCommand(@NonNull Command command) {
        if (satellite == null) throw new SatelliteNotAttachedException();
        satellite.execute(command);
    }

    @Override
    public void attachSatellite(@NonNull Satellite satellite) {
        this.satellite = satellite;
    }
}
