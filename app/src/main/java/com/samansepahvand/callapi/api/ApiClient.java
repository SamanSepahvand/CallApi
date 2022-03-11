package com.samansepahvand.callapi.api;

import com.samansepahvand.callapi.helper.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {



    private static ApiClient instance = null;
    private ApiInterface myApi;



    private ApiClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(ApiInterface.class);
    }

    public static synchronized ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    public ApiInterface getMyApi() {
        return myApi;
    }

}
