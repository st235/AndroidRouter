// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package com.github.sasd97.lib_router.commands.messages;

import android.support.annotation.NonNull;

public class ShowToast extends MessageCommand {

    private final int duration;

    @NonNull
    private final String text;

    private ShowToast(int duration,
                      @NonNull String text) {
        this.text = text;
        this.duration = duration;
    }

    public static ShowToast showToast(int duration,
                                      @NonNull String text) {
        return new ShowToast(duration, text);
    }

    @NonNull
    @Override
    public Message getMessage() {
        Message message = new Message();
        message.setDuration(duration);
        message.setMessage(text);
        return message;
    }
}
