package com.persona.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persona.modelo.Persona;
import com.persona.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	private PersonaRepository repository;

	@Override
	public List<Persona> listPersona() {
		return (List<Persona>) repository.findAll();
	}

	@Override
	public Optional<Persona> getPersonaById(int id) {
		return repository.findById(id);
	}

	@Override
	public Persona savePersona(Persona persona) {
		repository.save(persona);
		return persona;
	}

	@Override
	public void deletePersona(int id) {
		repository.deleteById(id);
	}
	

}
