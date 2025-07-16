package com.mycompany.property_management.Service.Impl;

import com.mycompany.property_management.Converter.UserConvertor;
import com.mycompany.property_management.DTO.UserDtlDTO;
import com.mycompany.property_management.Entity.UserEntity;
import com.mycompany.property_management.Repository.UserRepository;
import com.mycompany.property_management.Service.UserDtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDtlService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConvertor userConvertor;

    @Override
    public UserDtlDTO register(UserDtlDTO userDTO) {
        UserEntity en = UserConvertor.convertUserDTOtoEntity(userDTO);
        en = userRepository.save(en);

        UserDtlDTO DTO =UserConvertor.convertUserEntitytoDTO(en);
        return DTO;
    }

    @Override
    public UserDtlDTO login(String userEmail, String password) {
        return null;
    }
}
