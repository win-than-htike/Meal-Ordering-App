package xyz.padc.mealordering.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import xyz.padc.mealordering.data.vos.Meal;

/**
 * Created by winthanhtike on 8/18/16.
 */
public class MealListResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("meal_list")
    @Expose
    private List<Meal> mealList = new ArrayList<Meal>();

    public MealListResponse(Integer code, String message, List<Meal> mealList) {
        this.code = code;
        this.message = message;
        this.mealList = mealList;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<Meal> getMealList() {
        return mealList;
    }
}
