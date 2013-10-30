package org.jks.persistence.impl;

import org.jks.domain.Comment;
import org.jks.persistence.CommentDao;
import org.jks.persistence.common.AbstractHibernateDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commentDao")
public class CommentDaoImpl extends AbstractHibernateDAO<Comment, Long> implements CommentDao {

    public CommentDaoImpl() {
        setClazz(Comment.class);
    }

    @Override
    public List<Comment> getCommentsByArticleId(long articleId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Comment> getCommentsByArticleId(long articleId, int start, int end) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
