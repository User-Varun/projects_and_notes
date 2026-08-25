package com.varun.proxies;

import org.springframework.stereotype.Component;

import com.varun.model.Comment;

@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
     

    @Override
    public void sendComment(Comment comment){
        System.out.println("Sending Comment for comment " + comment.getText() );
    }
}
