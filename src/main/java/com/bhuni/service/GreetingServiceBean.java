package com.bhuni.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhuni.model.Greeting;
import com.bhuni.repository.GreetingRepository;

@Service
public class GreetingServiceBean implements GreetingService {

	@Autowired
	private GreetingRepository greetingRepository;
	/*private static Long nextId;
	private static Map<Long,Greeting> greetingMap;
	
	private static Greeting save(Greeting greeting){
		System.out.println("###"+greeting.getText());
		if(greetingMap == null){
			greetingMap = new HashMap<Long,Greeting>();
			nextId = new Long(1);
		}
		
		//if update
		if(greeting.getId() !=null){
			Greeting oldGreeting = greetingMap.get(greeting.getId());
			if(oldGreeting==null){
				return null;
			}
			greetingMap.remove(greeting.getId());
			greetingMap.put(greeting.getId(), greeting);
			return greeting;
			}
		
		//if create
		greeting.setId(nextId);
		nextId = nextId+1;
		greetingMap.put(greeting.getId(), greeting);
		return greeting;
	}
	
	static{
		System.out.println("##############Executing static block####################");
		Greeting g1 = new Greeting();
		g1.setText("Hello");
		save(g1);
		
		Greeting g2 = new Greeting();
		g2.setText("How are you");
		save(g2);
	}
	private static boolean remove(Long id){
		Greeting deletedGreeting =  greetingMap.remove(id);
		if(deletedGreeting == null)
			return false;
		return true;
	}
	
	*/
	
	
	@Override
	public Collection<Greeting> findAllGreetings() {
		System.out.println("repository!!!");
		Collection<Greeting> greetings = greetingRepository.findAll();
		System.out.println("greetings:"+greetings);
		return greetings;
	}

	@Override
	public Greeting findOne(Long id) {
		Greeting greeting = greetingRepository.findOne(id);
		return greeting;
	}

	@Override
	public Greeting create(Greeting greeting) {
		if(greeting.getId() !=null)
			return null;
		Greeting savedGreeting = greetingRepository.save(greeting);
		return savedGreeting;
	}

	@Override
	public Greeting update(Greeting greeting) {
		
		Greeting greetingIdpersisted = findOne(greeting.getId());
		if(greetingIdpersisted==null)
			return null;
			
		Greeting updatedGreeting = greetingRepository.save(greeting);
		return updatedGreeting;
	}

	@Override
	public void delete(Long id) {
		greetingRepository.delete(id);

	}

}
