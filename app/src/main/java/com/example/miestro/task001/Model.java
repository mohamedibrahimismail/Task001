package com.example.miestro.task001;

/**
 * Created by MIESTRO on 04/09/2018.
 */

public class Model {
    String id;
    String TitleEN;
    String TitleAR;
    String photo;
    String ProductCount;
    String havemodel;
    Model Subcategories;

    public Model (String id, String TitleEN,String TitleAR,String photo,String ProductCount,String havemodel,Model Subcategories){

        this.id=id;
        this.TitleEN=TitleEN;
        this.TitleAR=TitleAR;
        this.photo=photo;
        this.ProductCount=ProductCount;
        this.havemodel=havemodel;
        this.Subcategories=Subcategories;

    }

    public String getId() {
        return id;
    }

    public String getTitleEN() {
        return TitleEN;
    }

    public String getTitleAR() {
        return TitleAR;
    }

    public String getPhoto() {
        return photo;
    }

    public String getProductCount() {
        return ProductCount;
    }

    public String getHavemodel() {
        return havemodel;
    }

    public Model getSubcategories() {
        return Subcategories;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitleEN(String titleEN) {
        TitleEN = titleEN;
    }

    public void setTitleAR(String titleAR) {
        TitleAR = titleAR;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setProductCount(String productCount) {
        ProductCount = productCount;
    }

    public void setHavemodel(String havemodel) {
        this.havemodel = havemodel;
    }

    public void setSubcategories(Model subcategories) {
        Subcategories = subcategories;
    }
}
