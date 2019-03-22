package com.padcmyanmar.padc7.mmnews.network;

import com.padcmyanmar.padc7.mmnews.delegates.LoginResponseDelegate;
import com.padcmyanmar.padc7.mmnews.delegates.NewsResponseDelegate;

public interface NewsDataAgent {

    void loadNews(int page, String accessToken, NewsResponseDelegate delegate);

    void login(String phoneNo, String pasword, LoginResponseDelegate loginResponseDelegate);

    void register(String phoneNo, String name, String password,LoginResponseDelegate loginResponseDelegate);

}
