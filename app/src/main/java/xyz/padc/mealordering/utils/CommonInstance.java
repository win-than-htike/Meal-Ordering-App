package xyz.padc.mealordering.utils;

import com.google.gson.Gson;

/**
 * Created by winthanhtike on 8/18/16.
 */
public class CommonInstance {

    private static Gson gson = new Gson();

    public static Gson getGsonInstance(){
        return gson;
    }

}
