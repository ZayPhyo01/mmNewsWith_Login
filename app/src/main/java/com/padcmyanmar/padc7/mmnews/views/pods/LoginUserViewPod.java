package com.padcmyanmar.padc7.mmnews.views.pods;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc7.mmnews.R;
import com.padcmyanmar.padc7.mmnews.data.model.UserModelImpl;
import com.padcmyanmar.padc7.mmnews.data.vos.UserVO;

public class LoginUserViewPod extends RelativeLayout {

ImageView userProfile;
TextView userName,userPhone;
    public LoginUserViewPod(Context context) {
        super(context);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d("View pod ","start in "+getClass().getName());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("view pod","start");
        UserModelImpl userModel = UserModelImpl.getInstance();
        userName = findViewById(R.id.tv_name);
        userPhone = findViewById(R.id.tv_phone_no);
        userProfile = findViewById(R.id.iv_login_user);



        UserVO userVO = userModel.getUserInfo();
        userName.setText(userVO.getName());
        userPhone.setText(userVO.getPhoneNo());
        Glide.with(this)
                .load("http://chinesemov.com/images/actors2/Steven-Cheung-2.jpg")
                .into(userProfile);

    }
}
