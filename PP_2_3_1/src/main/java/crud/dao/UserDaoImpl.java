package crud.dao;

import crud.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getUsers() {

        return entityManager.createQuery("FROM User ", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {

        entityManager.merge(user);
    }

    @Override
    public User getUser(int id) {
        User user = entityManager.find(User.class, id);

        return user;
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }
}
