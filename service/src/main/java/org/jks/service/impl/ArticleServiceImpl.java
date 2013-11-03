package org.jks.service.impl;

import java.util.List;

import org.jks.domain.Article;
import org.jks.domain.Section;
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
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Article getCompleteArticle(long articleId, int comments) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
    public List<Article> getCompleteArticles(int comments) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
