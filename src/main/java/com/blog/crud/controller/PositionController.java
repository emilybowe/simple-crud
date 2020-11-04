package com.blog.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.crud.domain.Position;
import com.blog.crud.service.PositionService;


@RestController
@RequestMapping("/position")
public class PositionController {
	
	@Autowired
	PositionService positionService;
	
	//Get all Positions
	@GetMapping("/getAllPositions")
	public List<Position> getAllPositions() {
		return positionService.getAllPositions();
	}	

	//Create a new Position
	@PostMapping("/createPosition")
	public Position createPosition(@Valid @RequestBody Position position) {
		return positionService.createPosition(position);
	}
	
	//Get a Single Position
	@GetMapping("/getPosition/{id}")
	public Position getPositionById(@PathVariable (value = "id") Long positionId) {
		return positionService.getPositionById(positionId);
	}
	
	//Update a Position
	@PutMapping("/updatePosition/{id}")
	public Position updatePositionById(@PathVariable (value = "id") Long positionId, @Valid @RequestBody Position positionDetails) {
		return positionService.updatePositionById(positionId, positionDetails); 
	}
	
	//Delete a Position
	@DeleteMapping("/deletePosition/{id}")
	public ResponseEntity<?> deletePositionById(@PathVariable (value = "id") Long positionId) {
		return positionService.deletePositionById(positionId);
		
	}
}
