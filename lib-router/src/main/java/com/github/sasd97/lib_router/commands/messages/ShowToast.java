package com.github.sasd97.lib_router.commands.messages;

import android.support.annotation.NonNull;

/**
 * Created by alexander on 07/09/2017.
 */

public class ShowToast extends MessageCommand {

    private int duration;
    private String text;

    private ShowToast(int duration,
                      @NonNull String text) {
        this.text = text;
        this.duration = duration;
    }

    public static ShowToast showToast(int duration,
                                      @NonNull String text) {
        return new ShowToast(duration, text);
    }

    @Override
    public Message getMessage() {
        Message message = new Message();
        message.setDuration(duration);
        message.setMessage(text);
        return message;
    }
}
