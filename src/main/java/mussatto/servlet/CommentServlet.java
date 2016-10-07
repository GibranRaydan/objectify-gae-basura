package mussatto.servlet;

import com.google.gson.Gson;
import com.googlecode.objectify.ObjectifyService;
import mussatto.model.Comment;
import mussatto.service.OfyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class CommentServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Util.addCorsHeader(resp);
        List<Comment> comments = OfyService.ofy().load().type(Comment.class).order("-date").list();
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        Gson gson = new Gson();
        writer.write(gson.toJson(comments));
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String jsonPost = Util.readInputText(req);

        Map<String, Object> result = new Gson().fromJson(jsonPost, Map.class);

        String author = (String) result.get("author");
        String text = (String) result.get("text");
        String postID = (String) result.get("postID");

        Comment comment = new Comment(author, text, postID);
        OfyService.ofy().save().entity(comment).now();

        Util.responseOkJSON(resp);
    }

}
