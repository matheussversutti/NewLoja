package com.tool.eloja.models;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;

public class UsersDto {
	@NotEmpty(message ="Nome é requisitado")
	private String name;
	@NotEmpty(message ="Email é requisitado")
	private String email;
	@Min(0)
	private int cpf;
	@NotEmpty(message ="Senha é requisitado")
	private String senha;
	@NotEmpty(message="Grupo é requisitado")
	private String grupo;
	@NotEmpty(message="Status é requisitado")
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private MultipartFile imageFile;
	
	
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	
}
