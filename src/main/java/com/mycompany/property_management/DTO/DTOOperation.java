package com.mycompany.property_management.DTO;

import com.mycompany.property_management.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DTOOperation {

    @Value("${pms.dummy:}")//connect the different environment using java code /spring
    private String dummy;
   // ${pms.dummy:-- if we set : then it will not throw any exception when dummy is not set in properties file}

    @Value("${spring.datasource.url:}")
    private String devUrl;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")

        public String Say (@RequestParam ("param1") String param1)
        {
            return param1;
        }
        //http://localhost:8080/api/v1/hello?param1=gopi
/// /api/v1//hello
    @GetMapping("/add/{num1}/{num2}")

    public Integer demo(@PathVariable("num1") Integer num1 ,@PathVariable("num2") Integer num2)
    {
    return num1 + num2;
    }
    //http://localhost:8080/api/v1/add/10/20

    @PostMapping("/Hey")

    public ResponseEntity <DTOProperty> sample(@RequestBody DTOProperty property)
    {
        property = propertyService.demo(property);
        System.out.println(property);

        //to make end to end connection
        ResponseEntity<DTOProperty>  response = new ResponseEntity<>(property, HttpStatus.CREATED);
        return response;
        //http://localhost:8080/api/v1/Hey
    }
//http://localhost:8080/api/v1/CallServiceLayer


    // get all the properties from the database
@GetMapping("/Hey")
    public ResponseEntity<List<DTOProperty>> getAllProperties()
    {
        List<DTOProperty> lsProperty = propertyService.getAllProperties();
        System.out.println(dummy);
        System.out.println(devUrl);
        ResponseEntity<List<DTOProperty>> res = new ResponseEntity<>(lsProperty,HttpStatus.OK);
        return res;
    }
// GET ---- http://localhost:8080/api/v1/Hey
    //update all the values from one row
@PutMapping("/Hey/{id}")
    public ResponseEntity<DTOProperty>updateProperties(@RequestBody DTOProperty property,@PathVariable("id") Long id)
    {
     property=propertyService.updateProperties(property,id);
        ResponseEntity <DTOProperty> res = new ResponseEntity<>(property,HttpStatus.OK);
        return res;
    }
/// PUT --- http://localhost:8080/api/v1/Hey/1


 /// update the particular value from the database
    @PatchMapping("/Hey/update description/{id}")
    public ResponseEntity<DTOProperty> updatePropertyDescription(@RequestBody DTOProperty property,@PathVariable Long id)
    {
        property = propertyService.updatePropertyDescription(property,id);
        ResponseEntity<DTOProperty> res = new ResponseEntity<>(property,HttpStatus.OK);
        return res;
    }

    //delete the row from the data base
    @DeleteMapping("Hey/{id}")
    public ResponseEntity deleteProperty( @PathVariable Long id)
    {
        propertyService.deleteProperty(id);
        ResponseEntity<Void> res = new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        return res;
    }

    ///  DELETE -----http://localhost:8080/api/v1/Hey/2
}


