package com.lxi.office.officecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OfficeController {

    @GetMapping("/")
    public String showIndex()
    {
        return "index";
    }
    @RequestMapping("/goto")
    public String empHome()
    {
        return "emphome";
    }
}

