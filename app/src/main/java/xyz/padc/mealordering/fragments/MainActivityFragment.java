package xyz.padc.mealordering.fragments;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.padc.mealordering.MealOrderingApp;
import xyz.padc.mealordering.R;
import xyz.padc.mealordering.adapters.MealRVAdapter;
import xyz.padc.mealordering.data.models.MealModel;
import xyz.padc.mealordering.data.vos.Meal;
import xyz.padc.mealordering.events.MealSetEvent;
import xyz.padc.mealordering.utils.ItemClickListener;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @BindView(R.id.rv_meal)
    RecyclerView rvMeal;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private ItemClickListener itemClickListener;

    private MealRVAdapter mAdapter;

    private List<Meal> mealList = new ArrayList<>();

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mealList = MealModel.getInstance().getMealList();
        Log.d("Meal Ordering Fragment", mealList.size()+"");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        itemClickListener = (ItemClickListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);

        mAdapter = new MealRVAdapter(mealList, itemClickListener);
        rvMeal.setAdapter(mAdapter);
        rvMeal.setLayoutManager(new LinearLayoutManager(MealOrderingApp.getContext(), LinearLayoutManager.VERTICAL, false));

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe public void onDataLoaded(MealSetEvent event) {
        swipeRefreshLayout.setRefreshing(false);
        mAdapter.setItems(MealModel.getInstance().getMealList());
    }

}
