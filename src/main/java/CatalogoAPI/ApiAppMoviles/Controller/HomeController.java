package CatalogoAPI.ApiAppMoviles.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "CatalogoAPI OK - ver documentación en /doc/swagger-ui.html";
    }
}
