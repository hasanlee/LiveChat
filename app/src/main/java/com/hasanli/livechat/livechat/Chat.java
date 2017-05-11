package com.hasanli.livechat.livechat;

/**
 * Created by hasan on 10.05.2017.
 */

public class Chat {
    private String id;
    private String msg;
    private String name;
    private String imgUrl;

    public Chat(){}

    public Chat(String id, String msg, String name, String imgUrl) {
        this.id = id;
        this.msg = msg;
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
