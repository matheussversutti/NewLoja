package com.tool.eloja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tool.eloja.models.Users;
import com.tool.eloja.models.UsersDto;
import com.tool.eloja.services.RepositorioUsers;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsersController {
	@Autowired
	private RepositorioUsers repo;
	

	@GetMapping({"","/"})
	public String showProductList(Model model) {
		List<Users> usuario = repo.findAll();
		model.addAttribute("usuario",usuario);
		return "usuario/index";
	}

	
	
	
	@GetMapping("/create")
	public String showCreatePage(Model model) {
		UsersDto userDto = new UsersDto();
		model.addAttribute("userDto", userDto);
		return "usuario/Usuarios";
	
	}
	@PostMapping("/create")
	public String CreateUser(
			@Valid @ModelAttribute UsersDto userDto,
			   BindingResult result) {
		if(result.hasErrors()) {
			return "usuario/Usuarios";
		}
		Users user = new Users();
		user.setName(userDto.getName());
		user.setCpf(userDto.getCpf());
		user.setEmail(userDto.getEmail());
		user.setSenha(userDto.getSenha());
		user.setGrupo(userDto.getGrupo());
		user.setStatus(Boolean.valueOf(userDto.getStatus()));
		repo.save(user);
		return "redirect:/usuario";
	}
	
	@GetMapping("edit")
	public String showEditPage(
			Model model,
			@RequestParam int id){
		try {
			Users user = repo.findById(id).get();
			model.addAttribute("user",user);
			
			UsersDto userDto = new UsersDto();
			userDto.setName(user.getName());
			userDto.setCpf(user.getCpf());
			userDto.setEmail(user.getEmail());
			userDto.setSenha(user.getSenha());
			userDto.setGrupo(user.getGrupo());
			user.setStatus(Boolean.valueOf(userDto.getStatus()));
			model.addAttribute("userDto",userDto);
			
		}
		catch(Exception ex) {
			System.out.println("Exception: "+ ex.getMessage());
			return "redirect:/usuario";
		}
		return "usuario/EditUser";
		
	}
	@PostMapping("edit")
	public String UpdateEdit(
			Model model,
			@RequestParam int id,
			@Valid @ModelAttribute UsersDto userDto,
			BindingResult result){
		try {
			Users user = repo.findById(id).get();
			model.addAttribute("user",user);
			
			if(result.hasErrors()) {
				return "usuario/EditUser";
			}
			
			user.setName(userDto.getName());
			user.setCpf(userDto.getCpf());
			user.setEmail(userDto.getEmail());
			user.setSenha(userDto.getSenha());
			user.setGrupo(userDto.getGrupo());
			user.setStatus(Boolean.valueOf(userDto.getStatus()));
			repo.save(user);
		}
		catch(Exception ex) {
			System.out.println("Exception: "+ ex.getMessage());
			return "redirect:/usuario";
		}
		return "redirect:/usuario";
	}
	@GetMapping("/delete")
	public String deleteUser(@RequestParam int id){
		try {
			Users user = repo.findById(id).get();
			
			repo.delete(user);
		}
		catch(Exception ex) {
			System.out.println("Exception: "+ ex.getMessage());
			return "redirect:/usuario";
		}
		
		return "redirect:/usuario";
	}
}
