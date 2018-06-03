// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router;

import android.support.annotation.NonNull;

import com.github.sasd97.lib_router.commands.Command;
import com.github.sasd97.lib_router.satellites.Satellite;

/**
 * Platform-independent entity for navigation.
 */
public interface Router {
    /**
     * Execute the navigation command.
     * If an appropriate satellite will not be found to execute the command,
     * an exception will be thrown.
     * @param command or command chain which would be executed by satellite.
     */
    void pushCommand(@NonNull Command command);

    /**
     * Add satellite to handle navigation command group.
     * @param satellite - platform-dependent entity, which works with navigation.
     */
    void addSatellite(@NonNull Satellite satellite);

    /**
     * Removes satellite from router to avoid memory leaks.
     * @param type - unique id for satellite group.
     */
    void removeSatellite(int type);
}
