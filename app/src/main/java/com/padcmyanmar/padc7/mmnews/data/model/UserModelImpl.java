package com.padcmyanmar.padc7.mmnews.data.model;

import android.support.annotation.Nullable;

import com.padcmyanmar.padc7.mmnews.data.vos.UserVO;
import com.padcmyanmar.padc7.mmnews.delegates.LoginResponseDelegate;
import com.padcmyanmar.padc7.mmnews.network.NewsDataAgent;

public class UserModelImpl extends BaseModel implements UserModel {

    private static UserModelImpl userModelimpl;
    UserVO userVOInfo;


    private UserModelImpl() {
    }

    public static UserModelImpl getInstance() {
        if (userModelimpl == null) {
            userModelimpl = new UserModelImpl();
        }
        return userModelimpl;
    }


    @Override
    public UserVO login(String phone, String password, final UserLoginDelegate userLoginDelegate) {

        newsDataAgent.login(phone, password, new LoginResponseDelegate() {
            @Override
            public void onSuccess(UserVO userVO) {
                userLoginDelegate.onSuccess(userVO);
                userVOInfo = userVO;
            }

            @Override
            public void onError(String message) {
                userLoginDelegate.onError(message);
            }
        });

        return userVOInfo;

    }

    @Override
    public UserVO register(String name, String phone, String password, final UserLoginDelegate userLoginDelegate) {
        newsDataAgent.register(phone, name, password, new LoginResponseDelegate() {
            @Override
            public void onSuccess(UserVO userVO) {
                userLoginDelegate.onSuccess(userVO);
                userVOInfo = userVO;
            }

            @Override
            public void onError(String message) {
                userLoginDelegate.onError("Fail to register");
            }
        });
        return userVOInfo;
    }

    public UserVO getUserInfo() {
        return userVOInfo;
    }


}
