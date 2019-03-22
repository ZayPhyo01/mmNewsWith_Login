package com.padcmyanmar.padc7.mmnews.data.model;

import com.padcmyanmar.padc7.mmnews.data.vos.CommentsVO;
import com.padcmyanmar.padc7.mmnews.data.vos.FavouriteVO;
import com.padcmyanmar.padc7.mmnews.data.vos.NewsVO;
import com.padcmyanmar.padc7.mmnews.data.vos.SendToVO;

import java.util.List;

public interface NewsModel {

    List<NewsVO> getAllNews(NewsDelegate delegate,Boolean isForce);

    void addCommentNews(CommentsVO comment, NewsVO news);

    void favouriteNews(FavouriteVO favourite, NewsVO news);

    void sendTo(SendToVO sendTo, NewsVO news);

    interface NewsDelegate {
        void onNewsFetchFromNetwork(List<NewsVO> newsList);
        void onErrorFromNetwork(String message);
    }

}
