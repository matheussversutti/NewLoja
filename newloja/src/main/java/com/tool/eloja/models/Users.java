package com.tool.eloja.models;



import jakarta.persistence.*;
import jakarta.persistence.Id;





@Entity
@Table (name= "users")
public class Users {
     
	  @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;
	  private String name;
	  private String email;
	  private int cpf;
	  private String senha ;
	  
	  private String grupo;
	  private boolean status;
	      
      public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return senha.substring(0,1)+"******";
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

   
	
      
      
      
      
    
}
