package com.padcmyanmar.padc7.mmnews.data.vos;

import com.google.gson.annotations.SerializedName;

public class SendToVO {
    @SerializedName("send-to-id")
    private String sendToId;
    @SerializedName("sent-date")
    private String sentDate;
    @SerializedName("acted-user")
    private ActedUserVO actedUser;
    @SerializedName("received-user")
    private ActedUserVO receivedUser;

    public ActedUserVO getReceivedUser() {
        return receivedUser;
    }

    public String getSendToId() {
        return sendToId;
    }

    public String getSentDate() {
        return sentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }
}
