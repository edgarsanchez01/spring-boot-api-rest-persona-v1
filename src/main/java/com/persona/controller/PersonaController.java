package com.persona.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.persona.modelo.Persona;
import com.persona.service.IPersonaService;

/*
 * API /MICROSERVICIOS
 * 
 * VERBOS, RECURSOS : 	GET, PUT, DELETE, POST
 * 					SELECT, UPDATE, DELETE, INSERT
 * 
 * 
 * ENDPOINTS/RECURSOS: URI HTTP
 * 
 * <SERVER><WEBAPP><NAMESPACE><ACTION
 * 
 * http://localhost:7575/personas/listar
 * 
 */

/*
 * @CrossOrigin enlaza el proyecto backend(APIREST) con el proyceto frontend(ANGULAR, PUERTO 4200)
 * 
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"personas"})
public class PersonaController {


	@Autowired
	private IPersonaService service;

    
	//ENDPOINT, METHOD GET : http://localhost:7575/personas/listar
	@GetMapping("listar")
	public List<Persona> listarPersonas(){
		List<Persona> personas = (List<Persona>) service.listPersona();
		return personas;
	}
	
	
	/*
	 * PARAMETROS: {PARAM}
	 * 
	 * 											  OK
	 * ReponseEntity: STATUS DE UN SERVIDOR 100, 200, 300, 400, 500,
	 * 
	 */
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> getPersonaById(@PathVariable int id){
		Optional<Persona> persona = service.getPersonaById(id);
		if(persona.isPresent()) {
			//RETORNA STATUS 200 OK
			return ResponseEntity.ok(persona.get());
		}else {
			//RETORNA STATUS 404 NOT FOUND
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	/*
	 * @RequestBody: CONVERTIR JSON A OBJECT Y VICEVERSA ...
	 * 
	 * ENDPOINT, POST: http://localhost:7575/personas
	 * 
	 * FORMAT JSON {"nombre": "luis pererira", "telefono" : "20202020"}
	 * 
	 */
	
	@PostMapping
	public ResponseEntity<Persona> agregarPersona(@RequestBody Persona persona){
		persona = service.savePersona(persona);
		return new ResponseEntity<>(persona, HttpStatus.CREATED);
		
	}
	
	/*
	 * ENDPOINT, PUT 	 http:localhost:7575/personas/1
	 * 
	 * FORMAT JSON : {"nombre" : "luis pereira lopez", "telefono" : "123456798"}
	 * 
	 */
	
	@PutMapping("/{id}")
	public ResponseEntity<Persona> modificarPersonas(@RequestBody Persona persona, @PathVariable int id){
		persona.setId(id);
		persona = service.savePersona(persona);
		//RETORNA STATUS 201 CREATED SI ACTUALIZO ELD ATO
		return new ResponseEntity<>(persona, HttpStatus.CREATED);
	}
	
	
	/*
	 * ENDPOINT, DELETE: http://localhost:7575/personas/1
	 * 
	 */
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPersona(@PathVariable int id) {
	    Optional<Persona> persona = service.getPersonaById(id);

	    if(persona.isPresent()) {
	        service.deletePersona(id);
	        return ResponseEntity.ok().build();
	    } else {
	        return ResponseEntity.notFound().build();  // <--- ESTE ES EL 404
	    }
	}

	
	

}
