package com.mycompany.property_management.Converter;

import com.mycompany.property_management.DTO.UserDtlDTO;
import com.mycompany.property_management.Entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {

    public static UserEntity convertUserDTOtoEntity(UserDtlDTO userDtlDTO)
    {
        UserEntity entity = new UserEntity();
        entity.setOwnerEmail(userDtlDTO.getOwnerEmail());
        entity.setPassword(userDtlDTO.getPassword());
        entity.setOwnerName(userDtlDTO.getOwnerName());
        return entity;
    }

    public static UserDtlDTO convertUserEntitytoDTO(UserEntity userEntity)
    {
        UserDtlDTO userDtlDTO = new UserDtlDTO();
        userDtlDTO.setId(userEntity.getId());
        userDtlDTO.setOwnerEmail(userEntity.getOwnerEmail());
      //  userDtlDTO.setPassword(userEntity.getPassword());
        userDtlDTO.setOwnerName(userEntity.getOwnerName());
        return userDtlDTO;
    }
}
