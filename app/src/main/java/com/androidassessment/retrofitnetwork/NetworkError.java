package com.androidassessment.retrofitnetwork;

public class NetworkError extends RuntimeException {

    private int offlineCode;

    public NetworkError(int offLineError) {
        this.offlineCode = offLineError;
    }

    public static NetworkError createOfflineError() {
        return new NetworkError(ErrorCode.OFFLINE_ERROR);
    }

    public int getOfflineCode() {
        return offlineCode;
    }
}
