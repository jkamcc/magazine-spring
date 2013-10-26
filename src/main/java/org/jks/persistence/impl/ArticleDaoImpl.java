package org.jks.persistence.impl;


import org.jks.domain.Article;
import org.jks.persistence.ArticleDao;
import org.jks.persistence.common.AbstractHibernateDAO;

public class ArticleDaoImpl extends AbstractHibernateDAO<Article, Integer> implements ArticleDao  {

	public ArticleDaoImpl() {
        setClazz(Article.class);
    }
}
