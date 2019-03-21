package com.detroitlabs.hello;

import org.springframework.data.repository.CrudRepository;

import com.detroitlabs.hello.User;

public interface UserRepo extends CrudRepository<User, Integer> {


}
