package xyz.padc.mealordering;

import android.app.Application;
import android.content.Context;

/**
 * Created by winthanhtike on 8/18/16.
 */
public class MealOrderingApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
