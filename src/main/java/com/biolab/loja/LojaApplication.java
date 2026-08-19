package com.biolab.loja;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Deixando swagger disponivel
@OpenAPIDefinition(info = @Info(
        title = "LojaRevApi",
        version = "1.0",
        description = "Api para revisar crud com o tema de loja"
))
public class LojaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LojaApplication.class, args);
    }

}
