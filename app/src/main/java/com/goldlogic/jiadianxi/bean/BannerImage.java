package com.goldlogic.jiadianxi.bean;

/**
 * Created by Administrator on 2018/4/17.
 */

public class BannerImage {


    /**
     * Title : %e5%8a%a0%e7%82%b9%e6%81%af%e5%b9%b4%e5%ba%a6%e8%b4%a6%e5%8d%95
     * ImgUrl : http://m.jiadianxi.com/build/img/banner/share.png
     * RedirectUrl : http://m.jiadianxi.com/activityapi?callback=http%3a%2f%2fshare.jiadianxi.com%2fjdx%3fsource%3dios%26id%3d%5bid%5d{token}
     * Order : 1
     * Id : 1746
     */

    private String Title;
    private String ImgUrl;
    private String RedirectUrl;
    private int Order;
    private int Id;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String ImgUrl) {
        this.ImgUrl = ImgUrl;
    }

    public String getRedirectUrl() {
        return RedirectUrl;
    }

    public void setRedirectUrl(String RedirectUrl) {
        this.RedirectUrl = RedirectUrl;
    }

    public int getOrder() {
        return Order;
    }

    public void setOrder(int Order) {
        this.Order = Order;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
}
