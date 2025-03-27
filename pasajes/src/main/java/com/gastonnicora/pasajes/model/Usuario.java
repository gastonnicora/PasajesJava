package com.gastonnicora.pasajes.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.AssertTrue;

import java.util.UUID;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private UUID uuid;

	@NotNull(message = "El nombre es obligatorio")
	@NotBlank
	@Size(min = 2, max = 30)
	private String nombre;

	@NotNull(message = "El apellido es obligatorio")
	@NotBlank
	@Size(min = 2, max = 30)
	private String apellido;

	@NotNull(message = "El celular es obligatorio")
	@NotBlank
	@Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "{invalid.phonenumber}")
	private String celular;

	@NotNull(message = "El email es obligatorio")
	@NotBlank
	@Email
	private String email;

	@NotNull(message = "La fecha de nacimiento es obligatoria")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Past(message = "Debe ser una fecha anterior a hoy")
	private LocalDate nacimiento;

	@NotNull(message = "La contraseña es obligatoria")
	@NotBlank
	// @Size(min=8)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String pass;

	private String cuil;

	@NotNull(message = "El DNI es obligatorio")
	@Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos")
	@Pattern(regexp = "\\d{8}", message = "El DNI debe contener solo números")
	private String dni;

	@Transient
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String confirmarPass;

	private Boolean borrado = false;

	public UUID getUuid() {
		return uuid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	@AssertTrue(message = "El usuario debe ser mayor de edad (18+ años)")
	public boolean isNacimiento() {
		return nacimiento != null && Period.between(nacimiento, LocalDate.now()).getYears() >= 18;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public Boolean getBorrado() {
		return borrado;
	}

	public void setBorrado(Boolean borrado) {
		this.borrado = borrado;
	}

	public String getConfirmarPass() {
		return confirmarPass;
	}

	public void setConfirmarPass(String confirmarPass) {
		this.confirmarPass = confirmarPass;
	}

}
