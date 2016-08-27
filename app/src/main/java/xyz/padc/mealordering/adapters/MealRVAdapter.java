package xyz.padc.mealordering.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.padc.mealordering.MealOrderingApp;
import xyz.padc.mealordering.R;
import xyz.padc.mealordering.data.vos.Meal;
import xyz.padc.mealordering.utils.ItemClickListener;
import xyz.padc.mealordering.views.holders.MealViewHolder;

/**
 * Created by winthanhtike on 8/18/16.
 */
public class MealRVAdapter extends RecyclerView.Adapter<MealViewHolder> {

    private LayoutInflater inflater;
    private List<Meal> mealList = new ArrayList<>();
    private ItemClickListener itemClickListener;

    public MealRVAdapter(List<Meal> mealList,ItemClickListener itemClickListener) {
        inflater = LayoutInflater.from(MealOrderingApp.getContext());
        this.mealList = mealList;
        this.itemClickListener = itemClickListener;
    }

    public void setItems(List<Meal> mealList) {
        this.mealList = mealList;
        notifyDataSetChanged();
    }

    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.meal_card_item,parent,false);
        return new MealViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(MealViewHolder holder, int position) {
        holder.setData(mealList.get(position));
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }
}
