package com.mycompany.property_management.Controller;

import com.mycompany.property_management.DTO.UserDtlDTO;
import com.mycompany.property_management.Service.UserDtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class UserDtlController {

@Autowired
    public UserDtlService userDtlService;
    @PostMapping("/register")

    public ResponseEntity<UserDtlDTO> sample(@RequestBody UserDtlDTO userDtlDTO)
    {
        userDtlDTO = userDtlService.register(userDtlDTO);
        System.out.println(userDtlDTO);

        //to make end to end connection
        ResponseEntity<UserDtlDTO>  response = new ResponseEntity<>(userDtlDTO, HttpStatus.CREATED);
        return response;
        //http://localhost:8080/api/v1/Hey
    }
}
