package crud.dao;

import crud.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
}
