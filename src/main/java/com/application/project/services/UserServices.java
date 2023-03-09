package com.application.project.services;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHeadResponseDecorator;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.application.project.models.User;
import com.application.project.models.UserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServices{
    private RestTemplate restTemplate = new RestTemplate();

    public List<User> getUsers(int page){
        String dataUsers = "https://reqres.in/api/users?page="+page;
        ResponseEntity<UserResponse> response = restTemplate.
                                                                                        getForEntity(dataUsers, UserResponse.class);
        
        List<User> users = response.getBody().getData();
        return users;
    }

    public User getUserById(int id) {
        String url = "https://reqres.in/api/users/" + id;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
    
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root;
        try {
            root = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al procesar la respuesta JSON", e);
        }
    
        JsonNode userData = root.path("data");
        return mapper.convertValue(userData, User.class);
        
    }

    public User createUser(User newUser){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(newUser, headers);
        ResponseEntity<User> response = restTemplate.postForEntity("https://reqres.in/api/users", request, User.class);

        return response.getBody();
    }

    public void deleteUser(int id) {
        String url = "https://reqres.in/api/users/" + id;
        restTemplate.delete(url);
    }

    public User updateUser(int id, User userToUpdate) {
        String url = "https://reqres.in/api/users/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(userToUpdate, headers);
        restTemplate.put(url, request);
        return userToUpdate;
    }
}