package org.jks.persistence;

import java.sql.Timestamp;
import java.util.List;

import org.jks.domain.Article;
import org.jks.persistence.common.GenericDao;

public interface ArticleDao  extends GenericDao<Article, Long>  {


	public Article getArticleByTimestamp(Timestamp datearticle);
	
	public Article getArticleBySubject(String subject);
	
	public List<Article> getArticlesInSection(long section);

}
