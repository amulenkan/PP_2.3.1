package crud.dao;

import crud.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //private List<User> users;
    /*{
        users = new ArrayList<>();

        users.add(new User(1, "Ivan", "Ivanov"));
        users.add(new User(2, "Maria", "Sidorova"));
        users.add(new User(3, "Petr", "Petrov"));

    }*/
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
