package com.fr.adaming.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class RegisterDto {
	
	@NotNull
	private String nom;
	
	@NotNull
	private String prenom;
	
	@Email
	@NotNull
	private String email;
	
	@NotNull
	private String pwd;
}
