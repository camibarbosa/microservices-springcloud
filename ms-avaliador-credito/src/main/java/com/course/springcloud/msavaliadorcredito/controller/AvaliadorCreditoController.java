package com.course.springcloud.msavaliadorcredito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("avalicoes-credito")
public class AvaliadorCreditoController {
    @GetMapping
    public String status(){
        return "ok";
    }
}
