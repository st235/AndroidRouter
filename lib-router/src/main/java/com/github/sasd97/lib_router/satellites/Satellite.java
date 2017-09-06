package com.github.sasd97.lib_router.satellites;

import android.support.annotation.NonNull;

import com.github.sasd97.lib_router.commands.Command;

/**
 * Created by alexander on 06/09/2017.
 */

public interface Satellite {
    void execute(@NonNull Command command);
}
