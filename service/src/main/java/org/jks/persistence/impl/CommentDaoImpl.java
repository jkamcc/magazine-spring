package org.jks.persistence.impl;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jks.domain.Article;
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
    	return getCurrentSession().createCriteria(Comment.class)
                .add(Restrictions.eq("articleId", articleId))
                .addOrder(Order.desc("dateComment")).list();
    }

    @Override
    public List<Comment> getCommentsByArticleId(long articleId, int start, int end) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

	@Override
	public void deleteCommentById(long commentId) {
		Comment comment = (Comment) getCurrentSession().createCriteria(Comment.class)
				.add(Restrictions.eq("commentId", commentId));
		delete(comment);
	}
}
