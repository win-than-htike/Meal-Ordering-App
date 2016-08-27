package xyz.padc.mealordering.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by winthanhtike on 8/18/16.
 */
public class Meal implements Serializable{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("img_url")
    @Expose
    private String imgUrl;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("ingredients")
    @Expose
    private List<String> ingredients = new ArrayList<String>();

    public Meal(Integer id, String name, String imgUrl, String description, Integer price, List<String> ingredients) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.description = description;
        this.price = price;
        this.ingredients = ingredients;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
