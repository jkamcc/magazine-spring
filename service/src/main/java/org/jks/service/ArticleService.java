package org.jks.service;

import java.util.List;

import org.jks.domain.Article;

public interface ArticleService {
	
	public void addArticle(Article article);
	
    public Article getArticleById(long articleId);

    /**
     * Complete information of an article
     * @return An article with all comments inside and the name of the section
     */
    public Article getCompleteArticle(long articleId);

    /**
     * Complete information of an article
     * @param comments Quantity of comments to return
     * @return An article with the latest comments defined
     */
    public Article getCompleteArticle(long articleId, int comments);

    public List<Article> getArticles(int start, int end);

    public List<Article> getArticles();

    public List<Article> getCompleteArticles(int quantity, int comments);

    public Article getArticleBySubject(String subject);

    public void updateArticle(Article article);

    public void deleteArticle(Article article);

    public void deleteArticleById(long articleId);

}
