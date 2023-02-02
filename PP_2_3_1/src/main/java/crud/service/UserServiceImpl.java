package crud.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import crud.models.User;
import crud.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);

    }
}
