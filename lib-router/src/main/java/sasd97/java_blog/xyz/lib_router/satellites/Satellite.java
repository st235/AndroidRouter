package sasd97.java_blog.xyz.lib_router.satellites;

import android.support.annotation.NonNull;

import sasd97.java_blog.xyz.lib_router.commands.Command;

/**
 * Created by alexander on 06/09/2017.
 */

public interface Satellite {
    void execute(@NonNull Command command);
}
