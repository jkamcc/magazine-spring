package org.jks.persistence.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jks.domain.Article;
import org.jks.persistence.ArticleDao;
import org.jks.persistence.common.AbstractHibernateDAO;
import org.springframework.stereotype.Repository;

@Repository("articleDao")
public class ArticleDaoImpl extends AbstractHibernateDAO<Article, Long> implements ArticleDao  {

	public ArticleDaoImpl() {
        setClazz(Article.class);
    }

	@Override
	public Article getArticleByTimestamp(Timestamp datearticle) {
		 return (Article) getCurrentSession().createCriteria(Article.class)
                            .add(Restrictions.eq("datearticle", datearticle)).uniqueResult();
	}

	@Override
	public Article getArticleBySubject(String subject) {
		return (Article) getCurrentSession().createCriteria(Article.class)
                            .add(Restrictions.eq("subject", subject)).uniqueResult();
	}

	@Override
	public List<Article> getArticlesInSection(long section) {
		return getCurrentSession().createCriteria(Article.class)
                    .add(Restrictions.eq("section", section))
                    .addOrder(Order.desc("datearticle")).list();
	}

    @Override
    public List<Article> find(int start, int end) {

        String hsql = "FROM " + Article.class.getName() + " as a ORDER BY a.datearticle desc";
        Query q = getCurrentSession().createQuery(hsql);

        if (start > 0) {
            q.setFirstResult(start);
        }

        if (end > 0) {
            q.setMaxResults(end);
        }
        return q.list();
    }

    @Override
    public List<Article> findAll() {
        return getCurrentSession().createCriteria(Article.class.getName())
               .addOrder(Order.desc("datearticle")).list();
    }

    @Override
	public void deleteArticleById(long articleId) {
		Article article = (Article) getCurrentSession().createCriteria(Article.class).add(Restrictions.eq("articleid", articleId)).uniqueResult();
		delete(article);		
	}   
    
}
