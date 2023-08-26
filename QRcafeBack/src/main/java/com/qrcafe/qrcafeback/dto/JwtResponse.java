package com.qrcafe.qrcafeback.dto;

import com.qrcafe.qrcafeback.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class JwtResponse {
    private String token;
    private Collection<? extends GrantedAuthority> roles;
    private String username;
}
