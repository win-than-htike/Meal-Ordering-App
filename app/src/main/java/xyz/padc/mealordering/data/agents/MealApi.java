package xyz.padc.mealordering.data.agents;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.padc.mealordering.responses.MealListResponse;
import xyz.padc.mealordering.utils.MealOrderingConstants;

/**
 * Created by winthanhtike on 8/18/16.
 */
public interface MealApi {

    @FormUrlEncoded
    @POST(MealOrderingConstants.API_GET_MEAL_LIST)
    Call<MealListResponse> loadMealList(
            @Field(MealOrderingConstants.PARAM_ACCESS_TOKEN) String param);

}
