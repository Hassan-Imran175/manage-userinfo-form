package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.model.UserInfo;

public interface UserDao extends CrudRepository<UserInfo, Integer>{

}
