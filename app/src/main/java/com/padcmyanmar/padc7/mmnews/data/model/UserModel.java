package com.padcmyanmar.padc7.mmnews.data.model;

import com.padcmyanmar.padc7.mmnews.data.vos.UserVO;

public interface UserModel {

    UserVO login(String phone,String password,UserLoginDelegate userLoginDelegate);

    UserVO register(String name,String phone,String password,UserLoginDelegate userLoginDelegate);


    interface UserLoginDelegate {

        void onSuccess(UserVO userVO);

        void onError(String message);

    }


}
