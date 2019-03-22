package com.padcmyanmar.padc7.mmnews.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NewsVO {
    @SerializedName("news-id")
    private String newsId;
    @SerializedName("brief")
    private String brief;
    @SerializedName("details")
    private String detail;
    @SerializedName("images")
    private List<String> images;
    @SerializedName("posted-date")
    private String postedDate;
    @SerializedName("publication")
    private PublicationVO publication;
    @SerializedName("favorites")
    private List<FavouriteVO> favourites;
    @SerializedName("comments")
    private List<CommentsVO> comments;
    @SerializedName("sent-tos")
    private List<SendToVO> sendTos;

    public String getHeroImages() {
        return getImages().get(0);
    }

    public String getNewsId() {
        return newsId;
    }

    public String getBrief() {
        return brief;
    }

    public String getDetail() {
        return detail;
    }

    public List<String> getImages()

    {
       /* if(images == null)
            throw new NullPointerException("Images in NewsVo should'nt be null");
        */
       if(images == null){
           return new ArrayList<>();
       }
        return images;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public PublicationVO getPublication() {
        return publication;
    }

    public List<FavouriteVO> getFavourites() {
        return favourites;
    }

    public List<CommentsVO> getComments() {
        return comments;
    }

    public List<SendToVO> getSendTos() {
        return sendTos;
    }
}
