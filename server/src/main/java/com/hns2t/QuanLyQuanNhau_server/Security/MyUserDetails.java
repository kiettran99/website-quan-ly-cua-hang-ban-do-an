package com.hns2t.QuanLyQuanNhau_server.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hns2t.QuanLyQuanNhau_server.Responsitory.NguoiDungResponsitory;
import com.hns2t.QuanLyQuanNhau_server.model.NguoiDung;

@Service
public class MyUserDetails implements UserDetailsService {

  @Autowired
  private NguoiDungResponsitory userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final NguoiDung user = userRepository.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User '" + username + "' not found");
    }

    return org.springframework.security.core.userdetails.User
        .withUsername(username)//
        .password(user.getPassword())//
        .accountExpired(false)//
        .accountLocked(false)//
        .credentialsExpired(false)//
        .disabled(false)//
        .build();
  }

}
