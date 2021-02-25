package com.demobootweb;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    /**
     * Formatter 사용
     */
    @Test
    public void hello() throws Exception {
        this.mockMvc.perform(get("/hello/lee"))
                .andDo(print())
                .andExpect(content().string("hello1 lee"));
    }

    /**
     * Formatter 사용
     */
    @Test
    public void hello2() throws Exception {
        this.mockMvc.perform(get("/hello2")
                                .param("name","lee"))
                .andDo(print())
                .andExpect(content().string("hello2 lee"));
    }

    /**
     * jpa 사용
     */

    @Test
    public void hello3() throws Exception {
        Person person = new Person();
        person.setName("lee");
        Person savePerson = personRepository.save(person);

        this.mockMvc.perform(get("/hello3")
                .param("id", savePerson.getId().toString()))
                .andDo(print())
                .andExpect(content().string("hello3 lee"));
    }

    @Test
    public void helloStatic() throws Exception {
        this.mockMvc.perform(get("/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("hello index")));
    }

    @Test
    public void helloMobileStatic() throws Exception {
        this.mockMvc.perform(get("/mobile/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("hello mobile index")));
    }

    @Test
    public void stringMessage() throws Exception {
        this.mockMvc.perform(get("/message")
                                .content("hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));

    }
}