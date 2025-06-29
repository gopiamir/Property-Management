package com.mycompany.property_management.Service;

import com.mycompany.property_management.DTO.DTOProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface PropertyService {

     DTOProperty demo (DTOProperty property);
     List<DTOProperty> getAllProperties ();

     DTOProperty updateProperties(DTOProperty property, Long id);

     DTOProperty updatePropertyDescription( DTOProperty property,  Long id);
     void deleteProperty(Long id);
}
