package com.bhuni.api;


import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhuni.model.Greeting;
import com.bhuni.service.GreetingService;


@RestController
public class GreetingController {
	
	@Autowired 
	private GreetingService greetingService;
	
	@RequestMapping(value="/all",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public String getAsString(){
		return "Returned!!!";
	}
	@RequestMapping(
			value="/api/greetings",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Collection<Greeting>> getGreetings(){
		System.out.println("Inside getGreetings###############");
		Collection<Greeting> greetings = greetingService.findAllGreetings();
		return new ResponseEntity<Collection<Greeting>>(greetings,HttpStatus.OK);
		
	}
	
	@RequestMapping(
			value="/api/greetings/{id}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> getGreetingsById(@PathVariable("id") Long id){
		System.out.println("Inside getGreetingsById###############");
		Greeting greeting = greetingService.findOne(id);
		if(greeting == null){
			return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);
		}
			return new ResponseEntity<Greeting>(greeting,HttpStatus.OK);
		
	}
	
	@RequestMapping(
			value="/api/greetings",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<Greeting> createGreeting(@RequestBody Greeting greeting){
		System.out.println("Inside createGreeting###############");
		System.out.println("Greeting :" + greeting.getText());
		Greeting greetingCreated = greetingService.create(greeting);
		return new ResponseEntity<Greeting>(greeting,HttpStatus.CREATED);
	}
	
	@RequestMapping(
			value="/api/greetings/{id}",
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<Greeting> updateGreeting(@RequestBody Greeting greeting){
		System.out.println("Inside updateGreeting###############");
		Greeting greetingUpdated = greetingService.update(greeting);
		if(greetingUpdated==null){
			return new ResponseEntity<Greeting>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Greeting>(greeting,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="/api/greetings/{id}",
			method=RequestMethod.DELETE)
	public ResponseEntity<Greeting> deleteGreeting(Long id){
		System.out.println("Inside deleteGreeting###############");
		greetingService.delete(id);
		return new ResponseEntity<Greeting>(HttpStatus.NO_CONTENT);
	}


}
