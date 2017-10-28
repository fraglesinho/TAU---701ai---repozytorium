package pl.kosmala.tau.labtwo.forum;

import java.util.Date;

public class Forum {
    private int id;
    private String title;
    private String shortPost;
    private String fullPost;
    private String metaData;
    private int visitCount;
    private Date createData;

    public Forum(int id, String title, String shortPost, String fullPost, String metaData,
                int visitCount, Date createData) {
        this.id = id;
        this.title = title;
        this.shortPost = shortPost;
        this.fullPost = fullPost;
        this.metaData = metaData;
        this.visitCount = visitCount;
        this.createData = createData;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortPost() {
        return shortPost;
    }

    public void setShortPost(String shortPost) {
        this.shortPost = shortPost;
    }

    public String getFullPost() {
        return fullPost;
    }

    public void setFullPost(String fullPost) {
        this.fullPost = fullPost;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }


    public Date getCreateData() {
        return createData;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
    }
}
