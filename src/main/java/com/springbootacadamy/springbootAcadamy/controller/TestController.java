package com.springbootacadamy.springbootAcadamy.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//to unique the controller
@RequestMapping("api/v1/test")
@CrossOrigin
public class TestController {

//    mona mapping ekkd kiyl kiynn one
    @GetMapping(path = "/get-my-text")
    public void getMyText(){
       String myText="This is my 1st Spring boot App";
        System.out.println(myText);
    }
    @GetMapping(path = "/get-my-text-1")
    public String getMyText1(){
        String myText="This is my 1st Spring boot App";
        return myText;
    }

}
