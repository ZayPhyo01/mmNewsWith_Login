package com.padcmyanmar.padc7.mmnews.delegates;

import com.padcmyanmar.padc7.mmnews.data.vos.UserVO;

public interface LoginResponseDelegate {

    void onSuccess(UserVO userVO);

    void onError(String message);


}
