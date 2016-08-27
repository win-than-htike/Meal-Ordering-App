package xyz.padc.mealordering.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.padc.mealordering.MealOrderingApp;
import xyz.padc.mealordering.R;
import xyz.padc.mealordering.adapters.IngredientRVAdapter;
import xyz.padc.mealordering.data.vos.Meal;

/**
 * Created by winthanhtike on 8/18/16.
 */
public class DetailActivity extends AppCompatActivity {

    private static final String IE_MEAL_NAME = "IE_MEAL_NAME";

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.tv_price)
    TextView tvPrice;

    @BindView(R.id.tv_desc)
    TextView tvDesc;

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @BindView(R.id.col_img_meal)
    ImageView ivMealImage;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_ingredient)
    RecyclerView rvIngredients;

    private IngredientRVAdapter mAdapter;

    public static Intent newInstance(Meal meal){
        Intent intent = new Intent(MealOrderingApp.getContext(),DetailActivity.class);
        intent.putExtra(IE_MEAL_NAME,meal);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_detail_container);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ivMealImage.setTransitionName(getString(R.string.share_image_transition));
        }

        final Meal meal = (Meal) getIntent().getSerializableExtra(IE_MEAL_NAME);

        if (meal == null){
            throw new RuntimeException("Can't find obj");
        }else {
            tvPrice.setText(meal.getPrice().toString());
            tvDesc.setText(meal.getDescription());
            toolbarTitle.setText(meal.getName());

            Glide.with(ivMealImage.getContext())
                    .load(meal.getImgUrl())
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .error(R.mipmap.ic_launcher)
                    .into(ivMealImage);
        }

        mAdapter = new IngredientRVAdapter(meal.getIngredients());
        rvIngredients.setAdapter(mAdapter);
        rvIngredients.setLayoutManager(new LinearLayoutManager(MealOrderingApp.getContext(),LinearLayoutManager.VERTICAL,false));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
