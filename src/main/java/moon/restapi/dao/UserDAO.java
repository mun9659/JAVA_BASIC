package moon.restapi.dao;

import org.apache.ibatis.annotations.Mapper;

import moon.restapi.model.User;

@Mapper
public interface UserDAO {
    
    public User findByUsernameAndPassword(String username, String password);

}
