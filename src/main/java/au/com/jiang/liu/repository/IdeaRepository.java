package au.com.jiang.liu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.jiang.liu.dto.IdeaDto;

public interface IdeaRepository extends JpaRepository<IdeaDto, Integer> {

}
