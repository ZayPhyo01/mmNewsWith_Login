package com.padcmyanmar.padc7.mmnews.delegates;

import com.padcmyanmar.padc7.mmnews.data.vos.NewsVO;

import java.util.List;

public interface NewsResponseDelegate {

            void onSuccessGetNews(List<NewsVO> newsList);

            void onErrorGetNews(String message);
        }