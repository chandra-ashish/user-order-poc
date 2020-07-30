package com.telecom.user.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-06T06:07:26.529Z")

/** 
 * Users Health Controller java 
 * 
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users/health")
public class HealthController {

    @GetMapping(path= "/status")
    public ResponseEntity<?> healthStatus() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}