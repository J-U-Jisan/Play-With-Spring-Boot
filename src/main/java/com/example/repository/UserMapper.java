package com.example.repository;

import com.example.domain.user.model.MUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /** User signup */
    public int insertOne(MUser user);

    /** Get users */
    public List<MUser> findMany();

    /** Get user */
    public MUser findOne(String userId);
}
