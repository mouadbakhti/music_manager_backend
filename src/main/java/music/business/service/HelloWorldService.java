package music.business.service;

import org.springframework.stereotype.Service;
@Service
public class HelloWorldService {

    public String getHelloMessage() {
        return "Hello, People!";
    }
}