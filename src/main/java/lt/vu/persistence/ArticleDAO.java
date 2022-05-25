package lt.vu.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import lt.vu.entities.Article;

import java.util.List;


@ApplicationScoped
public class ArticleDAO {
    @Inject
    private EntityManager em;
    @Transactional
    public void persist(Article article){
        this.em.persist(article);
    }

    public Article findOne(Integer id){
        return em.find(Article.class, id);
    }

    public List<Article> getAll(){
        return em.createNamedQuery("Article.getAll", Article.class).getResultList();
    }

    public Article update(Article article){
        return em.merge(article);
    }
}
