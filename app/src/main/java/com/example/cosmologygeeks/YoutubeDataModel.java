package com.example.cosmologygeeks;

public class YoutubeDataModel {

    private String mtitle="";
    private String mdescription="";
    private String mpublishedAt="";
    private String thumbnail="";

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMdescription() {
        return mdescription;
    }

    public void setMdescription(String mdescription) {
        this.mdescription = mdescription;
    }

    public String getMpublishedAt() {
        return mpublishedAt;
    }

    public void setMpublishedAt(String mpublishedAt) {
        this.mpublishedAt = mpublishedAt;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
