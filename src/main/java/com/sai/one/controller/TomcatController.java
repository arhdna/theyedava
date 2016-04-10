package com.sai.one.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TomcatController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
        return "HI IAM RUNNING";
    }

}
