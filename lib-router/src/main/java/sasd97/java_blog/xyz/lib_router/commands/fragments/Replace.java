package sasd97.java_blog.xyz.lib_router.commands.fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by alexander on 06/09/2017.
 */

public class Replace extends FragmentCommand {

    private Fragment to;
    private String tag;

    public Replace(@NonNull Fragment to,
                   @Nullable String tag) {
        super();
        this.to = to;
        this.tag = tag;
    }

    public Replace(@NonNull Fragment to,
                   @Nullable String tag,
                   @NonNull FragmentCommand command) {
        super(command);
        this.to = to;
        this.tag = tag;
    }

    @Override
    public FragmentTransaction apply(int containerId,
                                     @NonNull FragmentTransaction transaction) {
        FragmentTransaction current = transaction.replace(containerId, to, tag);
        return command == null ?  current : command.apply(containerId, current);
    }
}
