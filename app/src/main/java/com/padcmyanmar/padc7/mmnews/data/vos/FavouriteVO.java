package com.padcmyanmar.padc7.mmnews.data.vos;

import com.google.gson.annotations.SerializedName;

public class FavouriteVO {
    @SerializedName("favorite-id")
    private String favouriteId;
    @SerializedName("favorite-date")
    private String favouriteDate;
    @SerializedName("acted-user")
    private ActedUserVO actedUserVO;

    public String getFavouriteId() {
        return favouriteId;
    }

    public String getFavouriteDate() {
        return favouriteDate;
    }

    public ActedUserVO getActedUserVO() {
        return actedUserVO;
    }
}
