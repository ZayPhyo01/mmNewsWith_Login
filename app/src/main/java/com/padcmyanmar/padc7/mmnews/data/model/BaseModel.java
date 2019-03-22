package com.padcmyanmar.padc7.mmnews.data.model;

import com.padcmyanmar.padc7.mmnews.network.HttpUrlConnectionNewsDataAgentImpl;
import com.padcmyanmar.padc7.mmnews.network.NewsDataAgent;
import com.padcmyanmar.padc7.mmnews.network.RetrofitDA;

abstract class BaseModel {
    NewsDataAgent newsDataAgent;

    BaseModel() {
        newsDataAgent = RetrofitDA.getInstance();
    }
}
