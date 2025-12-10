package com.persona.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PERSONA")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Persona {

	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "TELEFONO")
	private String telefono;
	
}
