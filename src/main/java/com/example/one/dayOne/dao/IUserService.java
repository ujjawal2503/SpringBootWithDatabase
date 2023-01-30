package com.example.one.dayOne.dao;
import com.example.one.dayOne.model.entity.RegisterUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IUserService extends CrudRepository<RegisterUserEntity,Integer> {

}
