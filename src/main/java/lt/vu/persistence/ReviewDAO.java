package lt.vu.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import lt.vu.entities.Review;


@ApplicationScoped
public class ReviewDAO {
    @Inject
    private EntityManager em;

    @Transactional
    public void persist(Review review){
        this.em.persist(review);
    }

    public Review findOne(Integer id){
        return em.find(Review.class, id);
    }

    public Review update(Review review){
        return em.merge(review);
    }

}
