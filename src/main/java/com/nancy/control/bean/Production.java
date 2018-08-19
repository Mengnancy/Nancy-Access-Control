package com.nancy.control.bean;

public class Production {
    private String idProduction;

    private String productName;

    private String productAuthor;

    private String productDesc;

    private String directory;

    public String getIdProduction() {
        return idProduction;
    }

    public void setIdProduction(String idProduction) {
        this.idProduction = idProduction == null ? null : idProduction.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductAuthor() {
        return productAuthor;
    }

    public void setProductAuthor(String productAuthor) {
        this.productAuthor = productAuthor == null ? null : productAuthor.trim();
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory == null ? null : directory.trim();
    }
}