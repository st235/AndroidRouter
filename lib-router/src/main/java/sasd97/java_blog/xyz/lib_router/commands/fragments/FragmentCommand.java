package sasd97.java_blog.xyz.lib_router.commands.fragments;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import sasd97.java_blog.xyz.lib_router.commands.CommandDecorator;
import sasd97.java_blog.xyz.lib_router.commands.activities.ActivityCommand;

/**
 * Created by alexander on 06/09/2017.
 */

public abstract class FragmentCommand extends CommandDecorator<FragmentCommand> {

    public FragmentCommand() {
    }

    public FragmentCommand(@NonNull FragmentCommand command) {
        super(command);
    }

    public abstract FragmentTransaction apply(int containerId,
                                              @NonNull FragmentTransaction transaction);
}
