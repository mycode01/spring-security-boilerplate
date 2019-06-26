package com.example.mybatis.service;

import com.example.mybatis.domain.Member;
import com.example.mybatis.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private static final String ROLE_PREFIX = "ROLE_";


    @Autowired
    MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        Member member = memberMapper.getByUserId(uid);
        User user = new User(member.getUid(), member.getUpw(), Arrays.asList(new SimpleGrantedAuthority(ROLE_PREFIX+"USER")));
        //security에서 사용하는 User객체는 uid, upw, 그리고 권한에 해당하는 list타입의 GrantedAuthority이다.
        //내부적으로 ROLE_ 이라는 prefix를 사용하므로 적용
        return user;
    }
}
