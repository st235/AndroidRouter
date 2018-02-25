// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.commands.fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

public class Replace extends FragmentCommand {

    private Fragment to;
    private String tag;

    private Replace(@NonNull Fragment to,
                    @Nullable String tag) {
        super();
        this.to = to;
        this.tag = tag;
    }

    private Replace(@NonNull Fragment to,
                    @Nullable String tag,
                    @NonNull FragmentCommand command) {
        super(command);
        this.to = to;
        this.tag = tag;
    }

    public static Replace replace(@NonNull Fragment to,
                                  @Nullable String tag) {
        return new Replace(to, tag);
    }

    public static Replace replace(@NonNull Fragment to,
                                  @Nullable String tag,
                                  @NonNull FragmentCommand command) {
        return new Replace(to, tag, command);
    }

    @Override
    public FragmentTransaction apply(int containerId,
                                     @NonNull FragmentTransaction transaction) {
        FragmentTransaction current = transaction.replace(containerId, to, tag);
        return command == null ?  current : command.apply(containerId, current);
    }
}
