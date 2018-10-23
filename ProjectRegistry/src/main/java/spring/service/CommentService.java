package spring.service;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.CommentDAO;
import spring.builder.CommentBuilder;
import spring.model.Comment;
import spring.model.User;


@Component("commentService")
@ComponentScan("spring.builder")
public class CommentService {

	@Autowired
	private CommentBuilder commentBuilder;
	
	@Autowired
	private CommentDAO commentDAO;
	
	
	@Transactional
	public void saveComment(Comment comment) {
		commentDAO.saveComment(comment);
	}
	
	public Comment buildComment(User commenter, String comment) {
		return commentBuilder.setCommenter(commenter)
					  		 .setDateTimePosted(new GregorianCalendar())
					  		 .setComment(comment)
					  		 .build();
	}
}
