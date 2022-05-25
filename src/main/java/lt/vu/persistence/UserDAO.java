package lt.vu.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import lt.vu.entities.User;

import java.util.List;


@ApplicationScoped
public class UserDAO {
    @Inject
    private EntityManager em;

    public List<User> getAll() {
        return em.createNamedQuery("User.getAll", User.class).getResultList();
    }

    @Transactional
    public void persist(User user){
        this.em.persist(user);
    }

    public User findOne(Integer id){
        return em.find(User.class, id);
    }

    public User update(User user){
        return em.merge(user);
    }
}
