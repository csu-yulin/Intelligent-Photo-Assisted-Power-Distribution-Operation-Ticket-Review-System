package csu.yulin.ipas.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lp
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String test() {
        return "Hello, IPAS!";
    }
}