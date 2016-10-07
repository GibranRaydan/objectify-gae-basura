package mussatto.service;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import mussatto.model.Comment;

/**
 * Created by mussatto on 07/10/16.
 */
public class OfyService {
    static {
        ObjectifyService.register(Comment.class);
    }

    public static Objectify ofy(){
        return ObjectifyService.ofy();
    }
}
