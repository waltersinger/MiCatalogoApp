package com.wsinger.micatalogo.data;


import java.util.List;

public interface AsyncDataResponse {
    void processFinished(List arrayList);
    void timeOutException();
}
