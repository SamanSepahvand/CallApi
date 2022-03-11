package com.samansepahvand.callapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetAllBrandsModelResult implements Serializable {

    @SerializedName("status")
    @Expose
    private boolean status ;

    @SerializedName("message")
    @Expose
    private String  message ;


    @SerializedName("data")
    @Expose
    private List<BrandList> data ;


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

    public List<BrandList> getData() {
        return data;
    }

    public void setData(List<BrandList> data) {
        this.data = data;
    }




    public class BrandList implements Serializable {

        @SerializedName("id")
        @Expose
        private String id  ;

        @SerializedName("catId")
        @Expose
        private String catId  ;

        @SerializedName("imageAddress")
        @Expose
        private String imageAddress  ;

        @SerializedName("name")
        @Expose
        private String name ;

        @SerializedName("catalogAddress")
        @Expose
        private String catalogAddress ;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCatId() {
            return catId;
        }

        public void setCatId(String catId) {
            this.catId = catId;
        }

        public String getImageAddress() {
            return imageAddress;
        }

        public void setImageAddress(String imageAddress) {
            this.imageAddress = imageAddress;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCatalogAddress() {
            return catalogAddress;
        }

        public void setCatalogAddress(String catalogAddress) {
            this.catalogAddress = catalogAddress;
        }
    }

}
