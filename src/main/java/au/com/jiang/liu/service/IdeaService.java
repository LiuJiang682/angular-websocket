package au.com.jiang.liu.service;

import java.util.List;

import javax.transaction.Transactional;

import au.com.jiang.liu.model.Idea;

public interface IdeaService {

	List<Idea> getIdeas();
	
	@Transactional
	Idea addIdea(Idea idea);
	
	@Transactional
	Idea updateIdea(Idea idea);
	
	@Transactional
	void deleteIdea(Idea idea);
}
