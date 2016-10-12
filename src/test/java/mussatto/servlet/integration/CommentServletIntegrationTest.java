package mussatto.servlet.integration;

import mussatto.util.JSONPost;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.fail;

public class CommentServletIntegrationTest {

    @Test
    public void commentServletTest() {
        Map<String, Object> params = new HashMap<>();

        params.put("author", "Noel Rosa");
        params.put("text", "com que roupa eu vou, pro samba que voce me convidou?");
        params.put("postID", "123456");
        JSONPost post = new JSONPost("http://localhost:8080/comment", params);

        try {
            post.doPost();
        } catch (IOException e) {
            System.out.println(e);
            fail();
        }

        System.out.println(post.getResponseCode());

        System.out.println(post.getResponse());
    }

}
