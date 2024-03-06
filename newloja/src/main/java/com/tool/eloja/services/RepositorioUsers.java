package com.tool.eloja.services;



import org.springframework.data.jpa.repository.JpaRepository;

import com.tool.eloja.models.Users;

public interface RepositorioUsers extends JpaRepository<Users,Integer> {

	
}
