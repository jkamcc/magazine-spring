package org.jks.service.impl;

import java.util.List;

import org.jks.domain.Article;
import org.jks.persistence.ArticleDao;
import org.jks.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	    @Autowired
	    ArticleDao articleDao;

	    @Override
	    public Article getArticleById(int articleId) {
	        return articleDao.findOne(articleId);
	    }

	    @Override
	    public List<Article> getArticles(int start, int end) {
	        return articleDao.findAll();
	    }

		@Override
		public void addArticle(Article article) {
			articleDao.create(article);
			
		}


}
