package wsi.spring.http;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wsi.spring.model.GenericResponse;

/**
 * Kontroler REST; dostępny pod localhost:8081/status
 */


@RestController
@CrossOrigin
@Slf4j
public class MainController {

    @GetMapping(value = "/status")
    public GenericResponse appStatus() {
        return new GenericResponse("Hello TheFunnyApp is running OK");
    }

}
