package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

        @Override
        public User registerUser(User user) {
            // Generate the password (you can use your password generation logic here)
            user.setPassword(generatePassword(user.getFirstName(), user.getMiddleName(), user.getLastName()));
            
            // Save the user to the database
            return userRepository.save(user);
        }

        // Example password generation method (modify as needed)
        private String generatePassword(String firstName, String middleName, String lastName) {
            // Generate password logic here
            return firstName.substring(0, 2) + middleName.substring(0, 2) + lastName.substring(0, 2) + generateRandomDigits();
        }

        private String generateRandomDigits() {
            // Generate random digits logic here (e.g., using Math.random())
            // You can generate a 3-digit random number as needed
            return String.valueOf(Math.floor(100 + Math.random() * 900)); // Replace with your logic
        }



}

