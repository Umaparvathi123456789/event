package com.uma.linkdlen.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uma.linkdlen.entity.Event;

public interface UserRepository extends JpaRepository<Event, Long> {

	Optional<Event> findById(Long id);

	void deleteById(Long id );


}
