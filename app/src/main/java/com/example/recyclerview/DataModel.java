package com.example.recyclerview;

public class DataModel {
    private String name;
    private String version;
    private int id_;
    private int image;
    private int bg;

    public DataModel(String name, String version, int id_, int image, int bg) {
        this.name = name;
        this.version = version;
        this.id_ = id_;
        this.image = image;
        this.bg = bg;


    }

    public int getBg() {
        return bg;
    }

    public void setBg(int bg) {
        this.bg = bg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getId_() {
        return id_;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
