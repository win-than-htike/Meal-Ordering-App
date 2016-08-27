package xyz.padc.mealordering.utils;

import android.widget.ImageView;

import xyz.padc.mealordering.data.vos.Meal;

/**
 * Created by winthanhtike on 8/18/16.
 */
public interface ItemClickListener {

    void onClick(Meal meal, ImageView ivMealImage);

}
