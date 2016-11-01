package com.bhuni.service;

import java.util.Collection;

import com.bhuni.model.Greeting;

public interface GreetingService {
	
	Collection<Greeting> findAllGreetings();
	Greeting findOne(Long id);
	Greeting create(Greeting greeting);
	Greeting update(Greeting greeting);
	void delete(Long id);

}
