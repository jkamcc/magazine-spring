package org.jks.persistence;

import org.jks.domain.Comment;
import org.jks.persistence.common.GenericDao;

import java.util.List;

public interface CommentDao extends GenericDao<Comment, Long> {

    //tienen que estar ordenados por fecha desc
    public List<Comment> getCommentsByArticleId(long articleId);

    public int countComments(long articleId);

    //tienen que estar ordenados por fecha desc
    public List<Comment> getCommentsByArticleId(long articleId, int start, int end);
    
    public void deleteCommentById(long commentId) ;

}
