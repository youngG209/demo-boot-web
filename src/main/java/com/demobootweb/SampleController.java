package com.demobootweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") Person person) {
        return "hello1 " + person.getName();
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam("name") Person person) {
        return "hello2 " + person.getName();
    }

    @GetMapping("/hello3")
    public String hello3(@RequestParam("id") Person person) {
        return "hello3 " + person.getName();
    }
}
