package xyz.padc.mealordering.data.models;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import xyz.padc.mealordering.data.agents.MealRetrofit;
import xyz.padc.mealordering.data.vos.Meal;
import xyz.padc.mealordering.events.MealSetEvent;

/**
 * Created by winthanhtike on 8/18/16.
 */
public class MealModel {

    private static MealModel objInstance;

    private List<Meal> mMealList;

    private MealModel() {
        Log.d("Data", "data");

        MealRetrofit.getInstance().loadMealList();
        mMealList = new ArrayList<>();

    }

    public static MealModel getInstance() {
        if (objInstance == null) {
            objInstance = new MealModel();
        }
        return objInstance;
    }

    public List<Meal> getMealList() {

        Log.d("Meal Ordering Model",mMealList.size()+"");
        return mMealList;
    }

    public void setMealList(List<Meal> mealList) {

        this.mMealList = mealList;
        Log.d("Meal Ordering Meal setList", mMealList.size()+"");
        EventBus.getDefault().post(new MealSetEvent());

    }

    public void setMealError(String message) {
        Log.e("Meal Application", message);
    }

}
