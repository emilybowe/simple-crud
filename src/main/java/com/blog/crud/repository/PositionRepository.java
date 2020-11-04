package com.blog.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blog.crud.domain.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

}
