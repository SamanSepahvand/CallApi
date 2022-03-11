package com.samansepahvand.callapi.api;

import com.samansepahvand.callapi.model.GetAllBrandsModelInput;
import com.samansepahvand.callapi.model.GetAllBrandsModelResult;
import com.samansepahvand.callapi.model.GetProductsModelResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {


    @POST("api.php")
    Call<GetAllBrandsModelResult> GetAllBrands(@Body GetAllBrandsModelInput model);


    @POST("api.php")
    Call<GetProductsModelResult> GetProducts(@Body GetAllBrandsModelInput model);

}
