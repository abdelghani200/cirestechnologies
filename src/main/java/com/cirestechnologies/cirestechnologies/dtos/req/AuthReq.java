package com.cirestechnologies.cirestechnologies.dtos.req;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthReq {
    private String username;
    private String password;
}
