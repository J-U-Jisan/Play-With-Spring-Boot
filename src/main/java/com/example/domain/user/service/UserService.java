package com.example.domain.user.service;

import com.example.domain.user.model.MUser;

import java.util.List;

public interface UserService {

    /** User signup */
    public void signup(MUser user);

    /** Get users */
    public List<MUser> getUsers();

    /** Get user */
    public MUser getUserOne(String userId);
}
