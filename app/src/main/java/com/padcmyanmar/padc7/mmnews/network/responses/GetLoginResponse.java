package com.padcmyanmar.padc7.mmnews.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.padc7.mmnews.data.vos.UserVO;

public class GetLoginResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("login_user")
    private UserVO loginVO;

    public UserVO getLoginVO() {
        return loginVO;
    }
}
