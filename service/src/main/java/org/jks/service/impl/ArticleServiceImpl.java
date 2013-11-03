package org.jks.service.impl;

import java.util.List;

import org.jks.domain.Article;
import org.jks.persistence.ArticleDao;
import org.jks.persistence.CommentDao;
import org.jks.persistence.SectionDao;
import org.jks.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private SectionDao sectionDao;

    @Autowired
    private CommentDao commentDao;

    @Override
    public Article getArticleById(long articleId) {
        return articleDao.findOne(articleId);
    }

    @Override
    public Article getCompleteArticle(long articleId) {

        return getCompleteArticle(articleId, -1);
    }

    @Override
    public Article getCompleteArticle(long articleId, int comments) {

        Article article = articleDao.findOne(articleId);
        article.setComments(commentDao.getCommentsByArticleId(articleId, 0, comments));
        article.setSectionName(sectionDao.findOne(article.getSectionid()).getSectionArticle());

        return article;
    }

    @Override
    public List<Article> getArticles(int start, int end) {
        return articleDao.find(start, end);
    }

    @Override
    public List<Article> getArticles() {
        return articleDao.findAll();
    }

    @Override
    public List<Article> getCompleteArticles(int quantity, int comments) {

        List<Article> articles = articleDao.find(0, quantity);

        for (Article article : articles) {
            article.setComments(commentDao.getCommentsByArticleId(article.getArticleid(), 0, comments));
            article.setSectionName(sectionDao.findOne(article.getSectionid()).getSectionArticle());
        }

        return articles;
    }

    @Override
    public void addArticle(Article article) {
        articleDao.create(article);
    }

    @Override
    public Article getArticleBySubject(String subject) {
        return articleDao.getArticleBySubject(subject);
    }

    @Override
    public void updateArticle(Article article) {
        articleDao.update(article);
    }

    @Override
    public void deleteArticle(Article article) {
        articleDao.delete(article);
    }

    @Override
    public void deleteArticleById(long articleId) {
        articleDao.deleteArticleById(articleId);
    }

}
