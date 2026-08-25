package com.varun.services;

import org.springframework.stereotype.Component;

import com.varun.model.Comment;
import com.varun.proxies.CommentNotificationProxy;
import com.varun.repository.CommentRespository;

@Component
public class CommentService {
    private final CommentRespository commentRespository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRespository cr , CommentNotificationProxy cnp){
        this.commentRespository = cr;
        this.commentNotificationProxy = cnp;
    }

    public void publishComment(Comment comment){
        commentRespository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
