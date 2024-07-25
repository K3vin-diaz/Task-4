package com.intership.task_4;

import com.intership.task_4.model.UserModel;
import com.intership.task_4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Date;


@SpringBootApplication
public class Task4Application implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(Task4Application.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		UserModel userModel = new UserModel();
		userModel.setName("Kevin Diaz");
		userModel.setPassword("KevinDiaz");
		userModel.setEmail("KevinDiaz@gmail.com");
		userModel.setActive(true);
		userModel.setRegistrationTime(LocalDateTime.now());
		userModel.setLastLoginTime(LocalDateTime.now());
		userRepository.save(userModel);


	}
}
