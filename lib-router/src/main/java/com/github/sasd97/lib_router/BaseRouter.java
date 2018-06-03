// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.sasd97.lib_router.commands.Command;
import com.github.sasd97.lib_router.exceptions.SatelliteNotAttachedException;
import com.github.sasd97.lib_router.satellites.Satellite;

import java.util.HashMap;
import java.util.Map;

/**
 * {@inheritDoc}
 */
public class BaseRouter implements Router {

    private final Map<Integer, Satellite> satellites = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void pushCommand(@NonNull Command command) {
        Satellite applicableSatellite = findSatellite(command);
        if (applicableSatellite == null) throw new SatelliteNotAttachedException();
        applicableSatellite.execute(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addSatellite(@NonNull Satellite satellite) {
        satellites.put(satellite.getType(), satellite);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeSatellite(int type) {
        satellites.remove(type);
    }

    @Nullable
    private Satellite findSatellite(@NonNull Command command) {
        for (Satellite satellite: satellites.values()) {
            if (satellite.isApplicable(command)) return satellite;
        }

        return null;
    }
}
