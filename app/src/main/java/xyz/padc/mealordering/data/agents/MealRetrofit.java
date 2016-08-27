package xyz.padc.mealordering.data.agents;


import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.padc.mealordering.data.models.MealModel;
import xyz.padc.mealordering.responses.MealListResponse;
import xyz.padc.mealordering.utils.CommonInstance;
import xyz.padc.mealordering.utils.MealOrderingConstants;

/**
 * Created by winthanhtike on 8/18/16.
 */
public class MealRetrofit implements DataAgents {

    private static MealRetrofit objInstance;

    private final MealApi theApi;

    private MealRetrofit() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MealOrderingConstants.MEAL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(CommonInstance.getGsonInstance()))
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(MealApi.class);

    }

    public static MealRetrofit getInstance() {

        if (objInstance == null) {
            objInstance = new MealRetrofit();
        }


        return objInstance;
    }


    @Override
    public void loadMealList() {
        final Call<MealListResponse> mealListResponseCall = theApi.loadMealList(MealOrderingConstants.ACCESS_TOKEN);
        mealListResponseCall.enqueue(new Callback<MealListResponse>() {
            @Override
            public void onResponse(Call<MealListResponse> call, Response<MealListResponse> response) {
                Log.d("Meal Ordering Retrofit",response.body().getMealList().size()+"");
                MealListResponse mealListResponse = response.body();
                MealModel.getInstance().setMealList(mealListResponse.getMealList());
            }

            @Override
            public void onFailure(Call<MealListResponse> call, Throwable t) {
                MealModel.getInstance().setMealError(t.getMessage());
            }
        });
    }
}
