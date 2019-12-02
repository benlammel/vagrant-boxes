package ch.lammel.photobooth.webservice.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping(value = {"/", "/what"})
    public ResponseEntity<String> index () {
    	
        return ResponseEntity.ok("Index page");
    }
}
