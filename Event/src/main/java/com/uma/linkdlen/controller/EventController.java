package com.uma.linkdlen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uma.linkdlen.entity.Event;
import com.uma.linkdlen.repo.UserRepository;

@RestController
@RequestMapping("/create/an/event")
public class EventController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/newevent")
	public Event newUser(@RequestBody Event event) {
		return userRepository.save(event);
	}

	@GetMapping("/eventdetails")
	public List<Event> getAlleventDetails() {
		return userRepository.findAll();
	}

	@GetMapping("/event/{id}")
	
	 public Optional<Event> getUserByeventType(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@PutMapping("/event/{id}")
	String updateUser(@RequestBody Event event, @PathVariable Long id) {
		Event event1 =userRepository.findById(id).get();
		event1.setEventType(event1.getEventType());
		event1.setFirstName(event1.getFirstName());
		event1.setLastName(event1.getLastName());
		event1.setStartDate(event1.getStartDate());
		event1.setStartTime(event1.getStartTime());
			event1.setEndDate(event1.getEndDate());
			event1.setEndTime(event1.getEndTime());
			event1.setDescription(event1.getDescription());
			 userRepository.save(event1);
		return "updated..";
	}

	@DeleteMapping("/event/delete/{id}")
	String deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return "User with id " + id + " has been deleted success.";
	}
	@GetMapping("/event")
public String getPage() {
		return "Welcome...";
}
	
}

