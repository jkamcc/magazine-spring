package org.jks.service.impl;

import java.util.List;

import org.jks.domain.Article;
import org.jks.domain.Comment;
import org.jks.persistence.CommentDao;
import org.jks.persistence.UserDao;
import org.jks.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	
	@Autowired
    private CommentDao commentDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void addComment(Comment comment) {
		commentDao.create(comment);		
	}

	@Override
	public List<Comment> getComments(long articleId) {
		return commentDao.getCommentsByArticleId(articleId);
	}

	@Override
	public List<Comment> getComments(long articleId, int start, int end) {
		 List<Comment> comments= commentDao.getCommentsByArticleId(articleId, start, end);
		 for (Comment comment : comments) {
			 	comment.setAuthorName((userDao.findOne(comment.getAuthor())).getUsername());
	     }
		return comments;
	}

	@Override
	public void updateComment(Comment comment) {
		commentDao.update(comment);		
	}

	@Override
	public void deleteComment(Comment comment) {
		commentDao.delete(comment);
	}

	@Override
	public void deleteCommentById(long commentId) {
		commentDao.deleteCommentById(commentId);
	}

}
