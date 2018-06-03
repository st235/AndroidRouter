// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.satellites;

import android.support.annotation.NonNull;

import com.github.sasd97.lib_router.commands.Command;

/**
 * Platform-dependent entity, which works with system navigation framework.
 */
public interface Satellite {
    /**
     * Get current satellite type.
     * @return unique id for satellite group (for example, activity group).
     */
    int getType();

    /**
     * Execute passed command by satellite.
     * @param command or command chain which contains navigation info.
     */
    void execute(@NonNull Command command);

    /**
     * Checks whether satellite can handle command or not.
     * @param command or command chain which contains navigation info.
     * @return true if satellite can handle command else otherwise.
     */
    boolean isApplicable(@NonNull Command command);
}
