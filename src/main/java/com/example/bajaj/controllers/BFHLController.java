package com.example.bajaj.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/bfhl")
public class BFHLController {

    @PostMapping
    public ResponseEntity<Map<String, Object>> handlePostRequest(@RequestBody Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<String> inputData = (List<String>) data.get("data");

            List<String> numbers = new ArrayList<>();
            List<String> alphabets = new ArrayList<>();
            List<String> lowercaseAlphabets = new ArrayList<>();

            for (String item : inputData) {
                if (item.matches("[0-9]+")) {
                    numbers.add(item);
                } else if (item.matches("[a-zA-Z]")) {
                    alphabets.add(item);
                    if (item.matches("[a-z]")) {
                        lowercaseAlphabets.add(item);
                    }
                }
            }

            String highestLowercase = lowercaseAlphabets.isEmpty() ? "" : Collections.max(lowercaseAlphabets);

            response.put("is_success", true);
            response.put("user_id", "john_doe_17091999");
            response.put("email", "john@xyz.com");
            response.put("roll_number", "ABCD123");
            response.put("numbers", numbers);
            response.put("alphabets", alphabets);
            response.put("highest_lowercase_alphabet", highestLowercase.isEmpty() ? "None" : highestLowercase);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            response.put("is_success", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Map<String, Integer>> handleGetRequest() {
        Map<String, Integer> response = new HashMap<>();
        response.put("operation_code", 1);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
