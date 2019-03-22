package com.padcmyanmar.padc7.mmnews.data.model;

import android.support.annotation.Nullable;

import com.padcmyanmar.padc7.mmnews.data.vos.CommentsVO;
import com.padcmyanmar.padc7.mmnews.data.vos.FavouriteVO;
import com.padcmyanmar.padc7.mmnews.data.vos.NewsVO;
import com.padcmyanmar.padc7.mmnews.data.vos.SendToVO;
import com.padcmyanmar.padc7.mmnews.delegates.NewsResponseDelegate;
import com.padcmyanmar.padc7.mmnews.network.HttpUrlConnectionNewsDataAgentImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsModelImpl extends BaseModel implements NewsModel {

    private static NewsModelImpl objInstance = null;

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private Map<String, NewsVO> mNewsRepository;

    private NewsModelImpl() {
        super();
        mNewsRepository = new HashMap<>();
    }

    public static NewsModelImpl getObjInstance() {
        if (objInstance == null) {

            objInstance = new NewsModelImpl();
        }
        return objInstance;
    }

    @Override
    public @Nullable
    List<NewsVO> getAllNews(final NewsDelegate delegate, Boolean isForce) {
        if (mNewsRepository.isEmpty() || isForce) {
            newsDataAgent.loadNews(1,
                    DUMMY_ACCESS_TOKEN,
                    new NewsResponseDelegate() {
                        @Override
                        public void onSuccessGetNews(List<NewsVO> newsList) {
                            for (NewsVO news : newsList) {
                                mNewsRepository.put(news.getNewsId(), news);
                            }
                            delegate.onNewsFetchFromNetwork(new ArrayList<NewsVO>(mNewsRepository.values()));
                        }

                        @Override
                        public void onErrorGetNews(String message) {
                            delegate.onErrorFromNetwork(message);
                        }
                    });
        } else {
            return new ArrayList<>(mNewsRepository.values());
        }
        return null;
    }

    /*
    *   @Override
    public @Nullable List<NewsVO> getAllNews(final NewsDelegate delegate,Boolean isForce) {
        if(mNewsRepository.isEmpty() || isForce){
            newsDataAgent.loadNews(1,
                    DUMMY_ACCESS_TOKEN,

                    new HttpUrlConnectionNewsDataAgentImpl.AsyncApiInvoker.NewsResponseDelegate() {
                @Override
                public void onSuccessGetNews(List<NewsVO> newsList) {
                    for(NewsVO news : newsList){
                        mNewsRepository.put(news.getNewsId(),news);
                    }
                    delegate.onNewsFetchFromNetwork(new ArrayList<NewsVO>(mNewsRepository.values()));
                }

                @Override
                public void onErrorGetNews(String message) {
                    delegate.onErrorFromNetwork(message);
                }
            });
        }else{
            return new ArrayList<>(mNewsRepository.values());
        }
        return null;
    }
    * */

    @Override
    public void addCommentNews(CommentsVO comment, NewsVO news) {

    }

    @Override
    public void favouriteNews(FavouriteVO favourite, NewsVO news) {

    }

    @Override
    public void sendTo(SendToVO sendTo, NewsVO news) {

    }
}
