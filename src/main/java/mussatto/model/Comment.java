package mussatto.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Date;

@Entity
public class Comment {
    @Id
    public Long id;

    public String author;

    public String text;

    public String postID;

    @Index
    public Date date;

    public Comment() {
    }

    public Comment(String author, String text, String postID) {
        this.author = author;
        this.text = text;
        this.postID = postID;
        this.date = new Date();
    }

}
