package au.com.jiang.liu.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.jiang.liu.dto.IdeaDto;
import au.com.jiang.liu.model.Idea;
import au.com.jiang.liu.repository.IdeaRepository;
import au.com.jiang.liu.service.IdeaService;

@Service
public class IdeaServiceImpl implements IdeaService {
	
	@Autowired
	private IdeaRepository repo;
	
	@Autowired
	private Mapper mapper;
	
	@Override
	public List<Idea> getIdeas() {
		List<IdeaDto> list = repo.findAll();
		List<Idea> out = new ArrayList<>();
		for (IdeaDto dto : list) {
			out.add(mapper.map(dto, Idea.class));
		}
		return out;
	}
	
	@Override
	@Transactional
	public Idea addIdea(Idea idea) {
		IdeaDto dto = mapper.map(idea, IdeaDto.class);
		return mapper.map(repo.saveAndFlush(dto), Idea.class);
	}
	
	@Override
	@Transactional
	public Idea updateIdea(Idea idea) {
		IdeaDto dto = repo.findOne(idea.getId());
		dto.setDescription(idea.getDescription());
		dto.setTitle(idea.getTitle());
		dto.setVotes(idea.getVotes());
		return mapper.map(repo.saveAndFlush(dto), Idea.class);
	}
	
	@Override
	@Transactional
	public void deleteIdea(Idea idea) {
		repo.delete(idea.getId());
	}
}