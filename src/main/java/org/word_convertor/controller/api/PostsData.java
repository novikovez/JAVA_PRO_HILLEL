package org.word_convertor.controller.api;


/**
 * Class org.word_convertor.controller.api.PostsData
 * author Igor Novikov
 * 10.09.24
 */

public class PostsData {
    private int userId;
    private int id;
    private String title;
    private String body;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
