package com.mycompany.property_management.Converter;

import com.mycompany.property_management.DTO.DTOProperty;
import com.mycompany.property_management.Entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    //here we have to convert DTO to Entity
    public PropertyEntity convertDTOtoEntity(DTOProperty property)
    {
        PropertyEntity pe = new PropertyEntity();
        pe.setAddress(property.getAddress());
        pe.setTitle(property.getTitle());
        pe.setDescription(property.getDescription());
        pe.setOwnerName(property.getOwnerName());
        pe.setOwnerEmail(property.getOwnerEmail());
        pe.setPrice(property.getPrice());
        return pe;
    }
    public DTOProperty convertEntityToDTO (PropertyEntity entity)
    {
        DTOProperty PDTO = new DTOProperty();
        PDTO.setId(entity.getId());
        PDTO.setAddress(entity.getAddress());
        PDTO.setTitle(entity.getTitle());
        PDTO.setDescription(entity.getDescription());
        PDTO.setOwnerName(entity.getOwnerName());
        PDTO.setOwnerEmail(entity.getOwnerEmail());
        PDTO.setPrice(entity.getPrice());
        return PDTO;

    }
}
