package com.mycompany.property_management.Controller;

import com.mycompany.property_management.ManagementProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addition")

// Request param calling  url - http://localhost:8080/api/v1/addition/add?num11=5.5&num22=2.2
public class CalculatorController
{
 @GetMapping("/add")
    public Double add(@RequestParam("num11") Double num1 , @RequestParam("num22") Double num2)
    {
       return num1+num2;
    }
    @GetMapping("/sub/{num1}/{num2}")
    public int substarct(@PathVariable("num1")  int num1 , @PathVariable("num2") int num2)
    {
        return num1-num2;
    }

    ///  we can use both request param and path variable in same method
    @GetMapping("/mul/{num3}")
    public int multiplication(@RequestParam("num1") int num1,@RequestParam("num2")
    int num2,@PathVariable("num3") int num3 , @RequestParam("num4") int num4)
    {
        return num1*num2+num3+num4;
    }

    //if we want to calculate 1000 values, then it should be challenging to add each param
   //values individually and also the value of param is also show directly in the URL,
   //so this time we can use post-mapping
@PostMapping("/cal")
    public ResponseEntity<Integer> calculation (@RequestBody ManagementProperty  property)
{
 Integer result = null;
 result = property.getNum1()+property.getNum2()+property.getNum3()+ property.getNum4();
    ResponseEntity<Integer> RE= new ResponseEntity<Integer>(result, HttpStatus.CREATED);
 return RE;
}
}
