package org.jks.web;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.jks.domain.Comment;
import org.jks.service.CommentService;
import org.jks.web.common.RestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Preconditions;

/**
 * @author juancarrillo
 */
@Controller
@RequestMapping("comment")
public class CommentServiceController {

    private static final Logger logger = LoggerFactory.getLogger(CommentServiceController.class);
	
	@Inject
	private CommentService commentService;
	
	@RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> getCommentsByArticleId(@PathVariable Long articleId) {

        List<Comment> comments = commentService.getComments(articleId);

        Preconditions.checkNotNull(comments, "The comments with the article "+ articleId + " cannot be found.");

        return comments;
    }
 
	@RequestMapping(value = "/get/{articleId}/{start}/{end}", method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> getCommentsByArticleIdRange(@PathVariable Long articleId, @PathVariable int start, @PathVariable int end) {

        List<Comment> comments = commentService.getComments(articleId, start, end);

        Preconditions.checkNotNull(comments, "The comments with the article "+ articleId + " cannot be found.");

        return comments;
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public RestMessage createUser(@Valid @RequestBody Comment comment) throws Exception {
        commentService.addComment(comment);
        return new RestMessage("Created comment " + comment);
    }
	 
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public RestMessage deleteUserById(@PathVariable Long commentId) {
        commentService.deleteCommentById(commentId);
        return  new RestMessage("Deleted comment "+ commentId);
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public RestMessage updateUser(@Valid @RequestBody Comment comment) throws Exception {
        commentService.updateComment(comment);
        return new RestMessage("Updated comment " + comment);
    }
}
