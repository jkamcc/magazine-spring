package org.jks.service;

import java.util.List;

import org.jks.domain.Article;

public interface ArticleService {
	
    public Article getArticleById(int articleId);

    public List<Article> getArticles(int start, int end);
    
}
