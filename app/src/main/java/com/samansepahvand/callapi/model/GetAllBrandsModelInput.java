package com.samansepahvand.callapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAllBrandsModelInput {


    @SerializedName("order")
    @Expose
    private String order ;

    @SerializedName("inputData")
    @Expose
    private InputData inputData ;


    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public InputData getInputData() {
        return inputData;
    }

    public void setInputData(InputData inputData) {
        this.inputData = inputData;
    }


}

