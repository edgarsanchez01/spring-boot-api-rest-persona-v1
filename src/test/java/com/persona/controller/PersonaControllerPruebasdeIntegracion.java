package com.persona.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester.MockMvcRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.persona.modelo.Persona;
import com.persona.repository.PersonaRepository;


/*
 * Las pruebas de integración son un enfoque de pruebas de software en el que se unen y 
 * prueban varios componentes o módulos de aplicaciones para evaluar cómo funcionan juntos. 
 */

@SpringBootTest
@AutoConfigureMockMvc
public class PersonaControllerPruebasdeIntegracion {

	@Autowired 
	private MockMvc mockMvc;
	
	@Autowired
	private PersonaRepository repository;
	
	@BeforeEach
	public void setup() {
		/*
		 * INICIALIAR O CAGAR BASE DE DATOS, LIMPIAR BD, CREAR UNA BD DE PRUEBA 
		 */
	}
	
	/*
	@Test
	public void testListarPersonas()throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/personas/listar"))
		//CODIGO STATUS SERVER 200 OK
		.andExpect(status().isOk())
		//ASEGURA QUE SEA UN ARREGLO EL QUE SE DEVUELVE
		.andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
		//ASEGURA QUE LA RESPUESTA NO ESTE VACIA
		.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
	}
	*/
	
	
	/*
	@Test
	public void testAgregarPersona() throws Exception {
	    Persona persona = new Persona();
	    persona.setNombre("carlos");
	    persona.setTelefono("222");

	    mockMvc.perform(MockMvcRequestBuilders.post("/personas")
	            .contentType("application/json")
	            .content("{\"nombre\":\"carlos\",\"telefono\":\"222\"}"))
	        .andExpect(status().isCreated())
	        .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("carlos"))
	        .andExpect(MockMvcResultMatchers.jsonPath("$.telefono").value("222"));
	}
	*/
	
	
	
	/*
	@Test
	public void testGetPersonasById() throws Exception {

	    Persona p = new Persona();
	    p.setNombre("Juan");
	    p.setTelefono("123");
	    p = repository.save(p); // ahora p.getId() tiene un ID real

	    mockMvc.perform(MockMvcRequestBuilders.get("/personas/" + p.getId()))
	        .andExpectAll(status().isOk())
	        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(p.getId()));
	}
	*/
	
	
	/*
	@Test
	public void testGetPersonasById() throws Exception {
	    
	    // Insertar dato previo en memoria
	    Persona persona = new Persona();
	    persona.setNombre("Carlos");
	    persona.setTelefono("222");
	    persona = repository.save(persona); // ahora tiene ID AUTOGENERADO

	    mockMvc.perform(get("/personas/" + persona.getId()))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.id").value(persona.getId()))
	        .andExpect(jsonPath("$.nombre").value("Carlos"));
	}
	*/



	
	
	
	@Test
	public void testdeletePersonasById() throws Exception{
	    Persona persona = new Persona();
	    persona.setNombre("Carlos");
	    persona.setTelefono("222");
	    persona = repository.save(persona); 

	    // USAR EL ID REAL
	    int idGenerado = persona.getId();

	    mockMvc.perform(MockMvcRequestBuilders.delete("/personas/" + idGenerado))
	        .andExpect(status().isOk());
	}

	
	
	
}