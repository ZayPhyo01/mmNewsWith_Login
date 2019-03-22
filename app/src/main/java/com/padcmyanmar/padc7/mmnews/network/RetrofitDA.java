package com.padcmyanmar.padc7.mmnews.network;

import android.util.Log;

import com.padcmyanmar.padc7.mmnews.data.vos.UserVO;
import com.padcmyanmar.padc7.mmnews.delegates.LoginResponseDelegate;
import com.padcmyanmar.padc7.mmnews.delegates.NewsResponseDelegate;
import com.padcmyanmar.padc7.mmnews.network.responses.GetLoginResponse;
import com.padcmyanmar.padc7.mmnews.network.responses.GetNewsResponse;
import com.padcmyanmar.padc7.mmnews.utils.MMNewsAppConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDA implements NewsDataAgent {

    private static RetrofitDA retrofitDA;
    private NewsAPI newsAPI;

    private RetrofitDA() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/")
                .addConverterFactory(GsonConverterFactory.create())

                .build();
        newsAPI = retrofit.create(NewsAPI.class);

    }

    public static RetrofitDA getInstance() {

        if (retrofitDA == null) {
            retrofitDA = new RetrofitDA();
        }
        return retrofitDA;
    }

    @Override
    public void loadNews(int page, String accessToken, final NewsResponseDelegate mNewsResponseDelegate) {

        Call<GetNewsResponse> newsResponseCall = newsAPI.loadNews(accessToken, page);

        newsResponseCall.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
                GetNewsResponse getNewsResponse = response.body();
                if (getNewsResponse.isResponseOk()) {
                    mNewsResponseDelegate.onSuccessGetNews(getNewsResponse.getNewsList());
                } else {
                    mNewsResponseDelegate.onErrorGetNews(getNewsResponse.getMessage());
                }
            }

            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void login(String phoneNo, String pasword, final LoginResponseDelegate loginResponseDelegate) {

        Call<GetLoginResponse> loginResponseCall = newsAPI.loginUser(phoneNo, pasword);
        loginResponseCall.enqueue(new Callback<GetLoginResponse>() {
            @Override
            public void onResponse(Call<GetLoginResponse> call, Response<GetLoginResponse> response) {

                Log.d("Retrofit", "Success");


                GetLoginResponse loginResponse = response.body();
                loginResponseDelegate.onSuccess(loginResponse.getLoginVO());

            }

            @Override
            public void onFailure(Call<GetLoginResponse> call, Throwable t) {
                loginResponseDelegate.onError("Fail to login");
                Log.d("Retrofit", " Fail");

            }
        });


    }

    @Override
    public void register(String phoneNo, String name, String password, final LoginResponseDelegate loginResponseDelegate) {

        Call<GetLoginResponse> loginResponseCall = newsAPI.registerUser(name, phoneNo, password);
        loginResponseCall.enqueue(new Callback<GetLoginResponse>() {
            @Override
            public void onResponse(Call<GetLoginResponse> call, Response<GetLoginResponse> response) {
                GetLoginResponse getLoginResponse = response.body();
                loginResponseDelegate.onSuccess(getLoginResponse.getLoginVO());
            }

            @Override
            public void onFailure(Call<GetLoginResponse> call, Throwable t) {
                loginResponseDelegate.onError("Register Fail");
            }
        });
    }


}
