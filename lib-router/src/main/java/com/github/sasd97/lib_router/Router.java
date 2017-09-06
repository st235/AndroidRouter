package com.github.sasd97.lib_router;

import android.support.annotation.NonNull;

import com.github.sasd97.lib_router.commands.Command;
import com.github.sasd97.lib_router.satellites.Satellite;

/**
 * Created by alexander on 06/09/2017.
 */

public interface Router {
    void pushCommand(@NonNull Command command);
    void attachSatellite(@NonNull Satellite satellite);
}
