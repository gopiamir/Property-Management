package com.mycompany.property_management.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
//used to not include null value ,here we are sending password but not getting retrun back in
// convetor so its showing null value , aviod to show null we can use it
@JsonIgnoreProperties(ignoreUnknown = true)  //its ignore un known
public class UserDtlDTO {
    private Long id;
    private String ownerName;
    private String ownerEmail;
    private String password;
}
