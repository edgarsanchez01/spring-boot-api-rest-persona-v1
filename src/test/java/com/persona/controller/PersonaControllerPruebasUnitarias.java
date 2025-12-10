package com.persona.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.persona.modelo.Persona;
import com.persona.service.IPersonaService;


@WebMvcTest(PersonaController.class)
public class PersonaControllerPruebasUnitarias {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private IPersonaService service;
	
	@Autowired
	private ObjectMapper objectMapper;

	/*
	 * PRUEBAS UNTIARIAS:
	 * 1.- DEBE HEREDAR DE TESTCASE
	 * 2.- DEBE EXISTER EL METODO TEST
	 * 3.- LOS NOMBRES DE LOS METODOS DEBEN COMENZAR CON LA PALABRA TEST, 
	 * Y LA ANOTACIÓN @TEST 
	 * 
	 */
	@TestConfiguration
	static class TestConfig{
		@Bean
		IPersonaService personaService(){
			return Mockito.mock(IPersonaService.class);
		}
	}
	
	
	
	//PRUEBA UNITARIA: GET	
	@Test
	void testListarPersonas()throws Exception{
		Persona p1 = new Persona();
		p1.setId(2);
		p1.setNombre("carlos");
		p1.setTelefono("2222");
		
		Persona p2 = new Persona();
		p2.setId(3);
		p2.setNombre("karla");
		p2.setTelefono("3333");
		
		Mockito.when(service.listPersona())
		.thenReturn(Arrays.asList(p1,p2));
		
		//SIMULACIÓN DE QUE EXISTEN LOS DATOS OBTENIDOS.
		mockMvc.perform(get("/personas/listar"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].nombre").value("carlos"))
		.andExpect(jsonPath("$[0].telefono").value("2222"))
		.andExpect(jsonPath("$[1].nombre").value("karla"))
		.andExpect(jsonPath("$[1].telefono").value("3333"));
	}
	
	
	
	/*
	//PRUEBA UNITARIA METODO POST
	@Test
	void testAgregarPersona() throws Exception{
		Persona p1 = new Persona();
		p1.setId(1);
		p1.setNombre("carlos");
		p1.setTelefono("2222");
		
		Mockito.when(service.savePersona(any(Persona.class)))
		.thenReturn(p1);
		
		mockMvc.perform(post("/personas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(p1)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.nombre").value("carlos"))
		.andExpect(jsonPath("$.telefono").value("2222"));
	}
	
	*/
	
	/*
	//PRUEBA UNITARIA METODO GET BY ID
		@Test
		void testGetPersonaByIdFound() throws Exception{
			Persona p1 = new Persona();
			p1.setId(1);
			p1.setNombre("carlos");
			p1.setTelefono("2222");
			
			Mockito.when(service.getPersonaById(1))
			.thenReturn(Optional.of(p1));
			
			mockMvc.perform(get("/personas/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.nombre").value("carlos"))
			.andExpect(jsonPath("$.telefono").value("2222"));
		}
		
		*/
		
		
	/*
		@Test
		void testGetPersonaByIdNotFound() throws Exception{
			Mockito.when(service.getPersonaById(22))
			.thenReturn(Optional.empty());
			
			mockMvc.perform(get("/personas/22"))
			.andExpect(status().isNotFound());
		}
		
		/*
		//PRUEBA UNTARIA DEL RECURSO PUT
		@Test
		void testModificarPersona() throws Exception{
			Persona p1 = new Persona();
			p1.setId(1);
			p1.setNombre("carlos");
			p1.setTelefono("2222");
			
			Mockito.when(service.savePersona(any(Persona.class)))
			.thenReturn(p1);
			
			mockMvc.perform(put("/personas/1")
					.contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(p1)))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.nombre").value("carlos"))
			.andExpect(jsonPath("$.telefono").value("2222"));
		}
		*/
		
		
		/*
		@Test
		void testDeltePersonaByIdFound() throws Exception{
			Persona p1 = new Persona();
			p1.setId(1);
			p1.setNombre("carlos");
			p1.setTelefono("2222");
			
			Mockito.when(service.getPersonaById(1))
			.thenReturn(Optional.of(p1));
			
			mockMvc.perform(delete("/personas/1"))
			.andExpect(status().isOk());
		}
		*/
		

		/*
		@Test
		void testDeletePersonaByIdNotFound() throws Exception{
			Mockito.when(service.getPersonaById(22))
			.thenReturn(Optional.empty());
			
			mockMvc.perform(delete("/personas/33"))
			.andExpect(status().isNotFound());
		}
		*/
		
}




