package sasd97.java_blog.xyz.lib_router;

import android.support.annotation.NonNull;

import sasd97.java_blog.xyz.lib_router.commands.Command;
import sasd97.java_blog.xyz.lib_router.satellites.Satellite;

/**
 * Created by alexander on 06/09/2017.
 */

public class BaseRouter implements Router {

    private Satellite satellite;

    @Override
    public void pushCommand(@NonNull Command command) {

    }

    @Override
    public void attachSatellite(@NonNull Satellite satellite) {
        this.satellite = satellite;
    }
}
