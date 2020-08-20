package com.uabc.edu.crud.controller;

import com.uabc.edu.crud.entity.User;
import com.uabc.edu.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("users", service.obtenerTodosUsuario());

        return "index";
    }

    @GetMapping("agregar")
    public String registrar(User user) {
        return "add-user";
    }

    @GetMapping("eliminar/{id}")
    public String eliminar(@PathVariable("id")long laID, Model model) {

        service.eliminarUsuario(laID);

        model.addAttribute("users", service.obtenerTodosUsuario());

        return "index";
    }


    @PostMapping("/adduser")
    public String addUser(User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "add-user";
        }
        service.registrarUsuario(user);

       return "redirect:/";
    }


}
