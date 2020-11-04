package com.blog.crud.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.blog.crud.domain.Position;
import com.blog.crud.repository.PositionRepository;

@Service
public class PositionService {
	
	@Autowired
	PositionRepository positionRepository;
	
	public List<Position> getAllPositions() {
		return positionRepository.findAll();
	}
	
	public Position createPosition(Position position) {
		return positionRepository.save(position);
	}

	public Position getPositionById(Long positionId) {
		return positionRepository.getOne(positionId);
	}

	public Position updatePositionById(Long positionId, @Valid @RequestBody Position positionDetails) {
		Position position = getPositionById(positionId);
		position.setTitle(positionDetails.getTitle());
		position.setLevel(positionDetails.getLevel());
		position.setSalary(positionDetails.getSalary());
		
		Position updatedPosition = positionRepository.save(position);
		return updatedPosition;
	}

	public ResponseEntity<?> deletePositionById(Long positionId) {
		Position position = getPositionById(positionId);
		positionRepository.delete(position);
		
		return ResponseEntity.ok().build();
	}	

}
