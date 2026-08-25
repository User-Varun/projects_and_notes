package com.varun.proxies;

import com.varun.model.Comment;


public interface CommentNotificationProxy {
   public void sendComment(Comment comment);
}
