package com.security.demospringsecurityform.form;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SampleService {

    public void dashboard() {
        // SecurityContextHolder 안에는 인증된 객체가 저장 => SecurityContextHolder Authentication을 담고 있고 ThreadLocal을 사용해서 Authentication을 어디서나 접근 가능하다
        // 1.SecurityContextHolder.getContext().getAuthentication() 을 통해 리턴받은 authentication 은 UsernamePasswordAuthentictionToken
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal =  authentication.getPrincipal();

        // 인증 정보 authentication에서 권한을 리턴받아 authorities에 저장
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Object credentials = authentication.getCredentials();
        boolean authenticated = authentication.isAuthenticated();
    }
}
