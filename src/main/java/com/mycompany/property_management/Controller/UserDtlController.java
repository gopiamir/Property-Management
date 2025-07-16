package com.mycompany.property_management.Controller;
import java.util.logging.Logger;
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


        //to make end to end connection
        return new ResponseEntity<>(userDtlDTO, HttpStatus.CREATED);

        //http://localhost:8080/api/v1/Hey
    }
}
