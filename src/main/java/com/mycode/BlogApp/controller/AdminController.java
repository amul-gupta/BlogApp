package com.mycode.BlogApp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

      @GetMapping
      public String adminCheck()
      {
          return "you have admin level access...";
      }

}
