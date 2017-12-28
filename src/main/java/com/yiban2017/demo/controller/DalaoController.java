package com.yiban2017.demo.controller;


import com.yiban2017.demo.service.DalaoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dalao on 17-12-26.
 */
@RestController
@RequestMapping("/")
public class DalaoController {
    @Autowired
    private DalaoService dalaoService;

    @RequestMapping("/")
    public Object showAll(Model model){
        model.addAttribute(dalaoService.findAll());
        return "index";
    }
    @RequestMapping("/login")
    public String doLogin(String name, String passwd, Model model, HttpServletRequest request,HttpServletResponse response){
         Iterable iterable= (Iterable) dalaoService.findAll();
         model.addAttribute(iterable);

        return "index";
    }

}
