package com.varun;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varun.model.Comment;
import com.varun.proxies.EmailCommentNotificationProxy;
import com.varun.repository.DBCommentRespository;
import com.varun.services.CommentService;

public class Main {
    public static void main(String[] args) {
       

        /* 
        // Without Spring

        var commentRepo = new DBCommentRespository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();


        var commentService = new CommentService(commentRepo , commentNotificationProxy);
        
        
        var comment = new Comment();
        
        comment.setAuthor("varun");
        comment.setText("i am the author of this text");
        
        commentService.publishComment(comment);
        */
        
        // with Spring 
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var comment = new Comment();
        comment.setAuthor("varun");
        comment.setText("demo text");
        
        var commentService = context.getBean(CommentService.class);

        commentService.publishComment(comment);

         context.close();
    }
}