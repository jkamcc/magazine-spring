package org.jks.persistence;

import java.util.List;

import org.jks.domain.Article;
import org.jks.persistence.common.GenericDao;

public interface ArticleDao  extends GenericDao<Article, Integer>  {

	@Override
	public void create(Article entity);

	@Override
	public Article findOne(Integer key);

	@Override
	public List<Article> findAll();

	@Override
	public Article update(Article entity);

	@Override
	public void delete(Article entity);

}
