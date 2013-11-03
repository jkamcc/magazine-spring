package org.jks.service.impl;

import java.util.List;

import org.jks.domain.Comment;
import org.jks.persistence.CommentDao;
import org.jks.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	
	@Autowired
    private CommentDao commentDao;
	
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
		return commentDao.getCommentsByArticleId(articleId, start, end);
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
