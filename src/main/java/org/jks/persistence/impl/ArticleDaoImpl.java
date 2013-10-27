package org.jks.persistence.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.jks.domain.Article;
import org.jks.persistence.ArticleDao;
import org.jks.persistence.common.AbstractHibernateDAO;
import org.springframework.stereotype.Repository;

@Repository("articleDao")
public class ArticleDaoImpl extends AbstractHibernateDAO<Article, Integer> implements ArticleDao  {

	public ArticleDaoImpl() {
        setClazz(Article.class);
    }

	@Override
	public Article getArticleByTimestamp(Timestamp datearticle) {
		 return (Article) getCurrentSession().createCriteria(Article.class).add(Restrictions.eq("datearticle", datearticle)).uniqueResult();
	}

	@Override
	public Article getArticleBySubject(String subject) {
		return (Article) getCurrentSession().createCriteria(Article.class).add(Restrictions.eq("subject", subject)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticlesInSection(Integer section) {
		return (List<Article>) getCurrentSession().createCriteria(Article.class).add(Restrictions.eq("section", section)).list();
	}

}
