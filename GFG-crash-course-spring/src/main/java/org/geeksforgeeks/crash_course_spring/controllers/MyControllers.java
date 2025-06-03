package org.geeksforgeeks.crash_course_spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyControllers {

    @GetMapping("/add_two_number")
    public int addTwoNo(@RequestParam int a, @RequestParam int b){
        return a+b;
    }

    @GetMapping("/mul_two_number")
    public int mulTwoNo(@RequestParam int a,@RequestParam int b){
        return a*b;
    }
}
