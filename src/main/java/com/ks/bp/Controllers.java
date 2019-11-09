package com.ks.bp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Controllers {
	@Autowired
	private ParticipantRepository pr ;
	
	
	
	/*
	 * public Controllers(ParticipantRepository pr) { this.pr = pr; }
	 */

	List<Participant> listp = new ArrayList<>();
	
	@GetMapping("/")
	public String sayHelloWord() {
		return "Hello world"; 
	}
	
	@GetMapping("/hello")
	public String sayHelloWord1(@RequestParam( name = "nom") String name, String prenom) {
		return "Bonjour " + name + " "+ prenom; 
	}
	
	@GetMapping("/hello/{name}/{prenom}")
	public String sayHelloWord2(@PathVariable String name,@PathVariable String prenom) {
		return "Bonjour " + name + " "+ prenom; 
	}
	
	@GetMapping("/opt/{a}/{b}")
	public String operation(@PathVariable int a,@PathVariable int b) {
		return "La somme est " + (a+b); 
	}
	
	@GetMapping("/opt")
	public String operation1( int a, int b) {
		return "La somme est " + (a+b) ;
	}
	@PostMapping("/participant")
	public Participant save(@RequestBody Participant p ) {
		p.setDate(new Date());
		
		
		pr.save(p);
		return pr.save(p);
	}
	@PutMapping("/participant/{id}")
	public Participant update(@RequestBody Participant p ,@PathVariable Long id) {
		Participant pnew = pr.findById(id).get();
		pnew.setFirstName(p.getFirstName());
		pnew.setLastName(p.getLastName());
		pnew.setAge(p.getAge());
		pnew.setDate(new Date());
		
		
		// pr.save(p);
		return pr.save(pnew);
	}
	 
	@GetMapping("/participant")
	public List<Participant>  getList( ) {
		
		return pr.findAll() ; 
	}
	
	@DeleteMapping("/participant/{id}")
	public void  delete(@PathVariable Long id) {
		
		 pr.deleteById(id);
	}
}
