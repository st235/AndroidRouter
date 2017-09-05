package sasd97.java_blog.xyz.lib_router;

import android.support.annotation.NonNull;

import sasd97.java_blog.xyz.lib_router.commands.Command;
import sasd97.java_blog.xyz.lib_router.satellites.Satellite;

/**
 * Created by alexander on 06/09/2017.
 */

public interface Router {
    void pushCommand(@NonNull Command command);
    void attachSatellite(@NonNull Satellite satellite);
}
