package com.example.repository;

import com.example.domain.user.model.MUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    /** User signup */
    public int insertOne(MUser user);

    /** Get users */
    public List<MUser> findMany(MUser user);

    /** Get user */
    public MUser findOne(String userId);

    /** Update user */
    public void updateOne(@Param("userId") String userId,
                          @Param("password") String password,
                          @Param("userName") String userName);

    /** Delete user */
    public int deleteOne(@Param("userId") String userId);
}
