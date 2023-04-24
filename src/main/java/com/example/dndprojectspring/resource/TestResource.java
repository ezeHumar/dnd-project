package com.example.dndprojectspring.resource;

import com.example.dndprojectspring.exception.ForbiddenException;
import com.example.dndprojectspring.exception.NoContentException;
import com.example.dndprojectspring.exception.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestResource {

    @PostMapping("")
    public String test(){
        return "Hello, world!!12";
    }

    @GetMapping("/error-not-found")
    public String testError(){
        throw new NotFoundException(null, null);
    }

    @GetMapping("/error-no-content")
    public String errorNoContent(){
        throw new NoContentException(null, null);
    }

    @GetMapping("/error-forbidden")
    public String errorForbidden(){
        throw new ForbiddenException("This is forbidden", null);
    }

}
