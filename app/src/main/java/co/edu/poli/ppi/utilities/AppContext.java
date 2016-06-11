package co.edu.poli.ppi.utilities;

import android.content.Context;

/**
 * Created by estebanmarinbetancur on 24/05/16.
 */
public class AppContext {

    private static Context globalContext;

    public static Context getGlobalContext() {
        return globalContext;
    }

    public static void setGlobalContext(Context globalContext) {
        AppContext.globalContext = globalContext;
    }
}
