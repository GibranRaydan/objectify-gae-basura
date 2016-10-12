package mussatto.service;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import mussatto.model.Comment;

public class OfyService {
    static {
        ObjectifyService.register(Comment.class);
    }
    public static Objectify ofy(){
        return ObjectifyService.ofy();
    }
}
