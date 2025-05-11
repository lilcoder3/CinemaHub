package com.upc.trabajoparcialcinemahub.security.dtos;


import java.util.Set;

@lombok.Data
public class AuthResponseDTO {
    private String jwt;
    private Set<String> roles;
}