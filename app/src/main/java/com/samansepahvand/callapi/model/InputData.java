package com.samansepahvand.callapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InputData {

    @SerializedName("brandId")
    @Expose
    private String brandId;


    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
}
