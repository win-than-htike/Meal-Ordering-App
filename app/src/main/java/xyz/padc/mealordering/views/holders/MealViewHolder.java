package xyz.padc.mealordering.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.padc.mealordering.R;
import xyz.padc.mealordering.data.vos.Meal;
import xyz.padc.mealordering.utils.ItemClickListener;

/**
 * Created by winthanhtike on 8/18/16.
 */
public class MealViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.iv_meal_image)
    ImageView ivMealImage;

    @BindView(R.id.tv_meal_name)
    TextView tvMealName;

    private Meal mMeal;

    private ItemClickListener itemClickListener;

    public MealViewHolder(View itemView,ItemClickListener itemClickListener) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        this.itemClickListener = itemClickListener;
        itemView.setOnClickListener(this);

    }

    public void setData(Meal meal){
        this.mMeal = meal;

        tvMealName.setText(meal.getName());

        Glide.with(ivMealImage.getContext())
                .load(meal.getImgUrl())
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher)
                .into(ivMealImage);

    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(mMeal,ivMealImage);
    }
}
