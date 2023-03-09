package com.application.project;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.application.project.controllers.UserController;
import com.application.project.models.User;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
		UserController userController = new UserController();
		

		userController.getUsers(2).
		stream().forEach(user -> System.out.println(user.to_string()));

		System.out.println(userController.getUserById(7).to_string());

		User user = new User(13,"cras991@hotmail.com", "John", "Doe","https://awp-content/uploads/2020/04/face_co.png");
		System.out.println(userController.createUser(user));
		System.out.println("Finished creating");

		System.out.println(userController.deleteUser(3));
		System.out.println("Deleted confirmed");
		
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
