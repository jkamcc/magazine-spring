package org.jks.service;

import org.jks.domain.Comment;

import java.util.List;

public interface CommentService {

    void addComment(Comment comment);

    List<Comment> getComments(long articleId);

    List<Comment> getComments(long articleId, int start, int end);

    void updateComment(Comment comment);

    void deleteComment(Comment comment);

    void deleteCommentById(long commentId);

}
