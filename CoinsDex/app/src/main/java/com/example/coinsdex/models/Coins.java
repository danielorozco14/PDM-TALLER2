package com.example.coinsdex.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coins {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("value")
    @Expose
    private Float value;
    @SerializedName("value_us")
    @Expose
    private Float valueUs;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("review")
    @Expose
    private String review;
    @SerializedName("isAvailable")
    @Expose
    private Boolean isAvailable;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getCountry() {
     return country;
     }

     public void setCountry(String country) {
     this.country = country;
     }

     public Float getValue() {
     return value;
     }

     public void setValue(Float value) {
     this.value = value;
     }

     public Float getValue_us() {
     return valueUs;
     }

     public void setValue_us(Float value_us) {
     this.valueUs = value_us;
     }

     public int getYear() {
     return year;
     }

     public void setYear(int year) {
     this.year = year;
     }

     public String getReview() {
     return review;
     }

     public void setReview(String review) {
     this.review = review;
     }

     public boolean isAvailable() {
     return isAvailable;
     }

     public void setAvailable(boolean available) {
     isAvailable = available;
     }

     public String getImg() {
     return img;
     }

     public void setImg(String img) {
     this.img = img;
     }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
