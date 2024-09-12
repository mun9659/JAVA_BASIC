package moon.restapi.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    
    @PostMapping("/login") 
    public ResponseEntity<?> test(@RequestBody Map<String, Object> loginDto) {

        

        return ResponseEntity.ok("테스트 중입니다.");
    }

}
