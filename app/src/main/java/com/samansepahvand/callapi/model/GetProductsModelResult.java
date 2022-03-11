package com.samansepahvand.callapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetProductsModelResult {


    @SerializedName("status")
    @Expose
    private boolean status ;

    @SerializedName("message")
    @Expose
    private String  message ;


    @SerializedName("data")
    @Expose
    private List<Products> data ;


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Products> getData() {
        return data;
    }

    public void setData(List<Products> data) {
        this.data = data;
    }

    public  class Products{

        @SerializedName("id")
        @Expose
        private String  id ;

        @SerializedName("brandId")
        @Expose
        private String brandId ;

        @SerializedName("name")
        @Expose
        private String name ;

        @SerializedName("description")
        @Expose
        private String description ;

        @SerializedName("catalogAddress")
        @Expose
        private String catalogAddress ;

        @SerializedName("videoAddress")
        @Expose
        private String videoAddress ;

        @SerializedName("click")
        @Expose
        private String click ;

        @SerializedName("special")
        @Expose
        private String special ;

        @SerializedName("brandName")
        @Expose
        private String brandName;

        @SerializedName("images")
        @Expose
        private List<String> images;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBrandId() {
            return brandId;
        }

        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCatalogAddress() {
            return catalogAddress;
        }

        public void setCatalogAddress(String catalogAddress) {
            this.catalogAddress = catalogAddress;
        }

        public String getVideoAddress() {
            return videoAddress;
        }

        public void setVideoAddress(String videoAddress) {
            this.videoAddress = videoAddress;
        }

        public String getClick() {
            return click;
        }

        public void setClick(String click) {
            this.click = click;
        }

        public String getSpecial() {
            return special;
        }

        public void setSpecial(String special) {
            this.special = special;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
