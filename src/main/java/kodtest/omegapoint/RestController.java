package kodtest.omegapoint;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/")
    public String demo() {
        return "HELLO";
    }

}
