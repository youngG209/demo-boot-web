package com.demobootweb;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/message")
//    @ResponseBody // @RestController일 때 당연히 생략(필요X)
    public String message(@RequestBody String person){
        return person;
    }
}
