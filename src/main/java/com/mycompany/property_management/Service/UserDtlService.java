package com.mycompany.property_management.Service;

import com.mycompany.property_management.DTO.UserDtlDTO;
import com.mycompany.property_management.Entity.UserEntity;

public interface UserDtlService {

     UserDtlDTO register(UserDtlDTO userDTO);
     UserDtlDTO login(String userEmail , String password);


}
