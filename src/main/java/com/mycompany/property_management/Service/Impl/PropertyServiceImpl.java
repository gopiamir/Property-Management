package com.mycompany.property_management.Service.Impl;

import com.mycompany.property_management.Converter.PropertyConverter;
import com.mycompany.property_management.DTO.DTOProperty;
import com.mycompany.property_management.Entity.PropertyEntity;
import com.mycompany.property_management.Repository.PropertyRepository;
import com.mycompany.property_management.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter PropertyConverter ;

    @Override
    public DTOProperty demo(DTOProperty property) {

        /// optimize the code purpose to introduce the converter layer

//        PropertyEntity pe = new PropertyEntity();
//        pe.setAddress(property.getAddress());
//        pe.setTitle(property.getTitle());
//        pe.setDescription(property.getDescription());
//        pe.setOwnerName(property.getOwnerName());
//        pe.setOwnerEmail(property.getOwnerEmail());
//        pe.setPrice(property.getPrice());
        PropertyEntity pe = PropertyConverter.convertDTOtoEntity(property);
        pe = propertyRepository.save(pe);
//response to client
        DTOProperty responceDTO = PropertyConverter.convertEntityToDTO(pe);
        return responceDTO;


    }

    @Override
    public List<DTOProperty> getAllProperties()
    {
        List<DTOProperty> lsprop = new ArrayList<>();
        List<PropertyEntity> lsproperty = (List<PropertyEntity>) propertyRepository.findAll();
        for(PropertyEntity pe:lsproperty) {
            DTOProperty responceDTO = PropertyConverter.convertEntityToDTO(pe);
            lsprop.add(responceDTO);
        }
        return lsprop;
    }

    @Override
    public DTOProperty updateProperties(DTOProperty property, Long id) {
        Optional<PropertyEntity> op =propertyRepository.findById(id);
        DTOProperty dto =null;
        if(op.isPresent())
        {
            PropertyEntity pe = op.get();
            pe.setAddress(property.getAddress());
            pe.setTitle(property.getTitle());
            pe.setDescription(property.getDescription());
            pe.setOwnerName(property.getOwnerName());
            pe.setOwnerEmail(property.getOwnerEmail());
            pe.setPrice(property.getPrice());
             dto = PropertyConverter.convertEntityToDTO(pe);
            pe = propertyRepository.save(pe);
        }
        else
        {
            System.out.println("ID not found");
        }
        return dto;
    }

    @Override
    public DTOProperty updatePropertyDescription(DTOProperty property, Long id) {
        Optional<PropertyEntity> op = propertyRepository.findById(id);
        DTOProperty dto = null;
        if (op.isPresent()) {
            PropertyEntity pe = op.get();
            pe.setDescription(property.getDescription());
            dto = PropertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long id) {
        System.out.println("sample");
        System.out.println("Demo");
        propertyRepository.deleteById(id);
    }

}
