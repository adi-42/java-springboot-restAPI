package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "classPost")
public class Post {
    private String id;
    private String type;
    private String desc;
    private Date date;
    private String address;
    private String price;
    private String size;

    public Post() {
    }

    public Post(String id) {
        this.id = id;
    }

    public Post(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Post(String type, String desc, Date date, String address, String price, String size) {
        this.type = type;
        this.desc = desc;
        this.date = date;
        this.address = address;
        this.price = price;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", price='" + price + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
