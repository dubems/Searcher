package com.nriagudubem.search.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class DashboardController {

    @GetMapping(value = "/dashboard/index")
    public String index() {
        return "dashboard/index";
    }
}
