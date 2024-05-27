package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.modelo.usuario;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {
    @Value("${index.mensaje}")
    String dato;

    @GetMapping("/")
    public String Inicio(Model modelo) {
        String mensaje = "Saludos desde Spring MVC con paso de información";
        modelo.addAttribute("mensaje", mensaje);
        modelo.addAttribute("dato", dato);

        usuario u1 = new usuario();
        u1.setCedula("1234");
        u1.setClave("abcd");
        u1.setNombre("Jhon Carlos Arrieta Arrieta");
        u1.setEmail("jhonarrieta@hotmail.com");
        modelo.addAttribute("alguien", u1);

        usuario u2 = new usuario();
        u2.setCedula("777");
        u2.setClave("El mejor");
        u2.setNombre("Jesus De Nazaret");
        u2.setEmail("jesucristoo@iglesia.coom");

        usuario u3 = new usuario();
        u3.setCedula("4321");
        u3.setClave("xyz");
        u3.setNombre("Fulanito De Tal");
        u3.setEmail("fulanito@gmail.com");

        List<usuario> listaUsuarios = Arrays.asList(u2, u3);
        modelo.addAttribute("usuarios", listaUsuarios);

        log.info("Ejecutando el controlador Inicio MVC");
        return "index";
    }
}
