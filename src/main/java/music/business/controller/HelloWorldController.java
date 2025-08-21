package music.business.controller;

import music.business.service.HelloWorldService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    private HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService hello) {
        this.helloWorldService = hello;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return helloWorldService.getHelloMessage();
    }

}
