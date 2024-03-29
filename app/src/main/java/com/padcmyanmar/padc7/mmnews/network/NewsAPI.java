package com.padcmyanmar.padc7.mmnews.network;

import com.padcmyanmar.padc7.mmnews.network.responses.GetLoginResponse;
import com.padcmyanmar.padc7.mmnews.network.responses.GetNewsResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NewsAPI {

    @FormUrlEncoded
    @POST("v1/getMMNews.php")
    Call<GetNewsResponse> loadNews (@Field("access_token")String accessToken,
                                    @Field("page") int page);

    @FormUrlEncoded
    @POST("v1/login.php")
    Call<GetLoginResponse> loginUser(@Field("phoneNo")String phoneNo,
                                     @Field("password")String password);

    @FormUrlEncoded
    @POST("v1/register.php")
    Call<GetLoginResponse> registerUser(@Field("name")String name,
                                        @Field("phoneNo")String phoneNo,
                                        @Field("password")String password);


}
