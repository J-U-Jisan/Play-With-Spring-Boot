package com.example.domain.user.service.impl;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class UserServiceImpl2 implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    /** User signup **/
    @Transactional
    @Override
    public void signup(MUser user) {
        // Existence check
        boolean exists = repository.existsById(user.getUserId());
        if (exists) {
            throw new DataAccessException("User already exists") {};
        }

        user.setDepartmentId(1);
        user.setRole("ROLE_GENERAL");

        // Password encryption
        String rawPassword  = user.getPassword();
        user.setPassword(encoder.encode(rawPassword));

        // insert
        repository.save(user);
    }

    /** Get user */
    @Override
    public List<MUser> getUsers(MUser user) {
        return repository.findAll();
    }

    /** Get user(1 record) */
    @Override
    public MUser getUserOne(String userId) {
        Optional<MUser> option = repository.findById(userId);
        MUser user = option.orElse(null);
        return user;
    }

    /** Update user */
    @Transactional
    @Override
    public void updateUserOne(String userId, String password, String userName) {

    }

    /** Delete user */
    @Transactional
    @Override
    public void deleteUserOne(String userId) {
        repository.deleteById(userId);
    }

    /** Get login user */
    @Override
    public MUser getLoginUser(String userId) {
        Optional<MUser> option = repository.findById(userId);
        MUser user = option.orElse(null);
        return user;
    }
}
