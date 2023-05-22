package com.example.springdatabasemybatisproviders.repository;

import com.example.springdatabasemybatisproviders.model.User;
import com.example.springdatabasemybatisproviders.model.response.UserResponse;
import com.example.springdatabasemybatisproviders.repository.providers.UserProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserRepository {

    @SelectProvider(type = UserProvider.class, method ="getAllUsers")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "secretKey", column = "secret_key"),
            @Result(property = "roles", column = "id", many =@Many(select = "findRolesByUserID"))
    })
    List<UserResponse> getAllUsers();

//    @Select("select * from users_tb")
//    @Result(property = "secretKey", column = "secret_key")
//    List<UserResponse> getAllUsers();
      @SelectProvider(type = UserProvider.class, method ="getRolesByUserId")
      List<String> findRolesByUserID(int id);

      //insert
//    @Select("insert into users_tb (username, gender, address, secret_key, email)\n" +
//            "values('testing', 'male', 'svay reang','2342', 'testing@gmail.com')")

    //insert new

    @InsertProvider(type = UserProvider.class, method = "insertNewUser")
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    int insertNewUserProvider(@Param("user") User user);

    @DeleteProvider(type = UserProvider.class, method = "deleteUserById")
    int deleteUserById(int id);

    @UpdateProvider(type = UserProvider.class, method = "updateUserById")
    int updateUserInfo(@Param("user") User user);

}
