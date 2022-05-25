package lt.vu.components;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Article;
import lt.vu.persistence.ArticleDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@Model
public class ArticlesComponent {
    @Inject
    private ArticleDAO articleDAO;

    @Getter
    @Setter
    private Article articleToCreate = new Article();

    @Getter
    private List<Article> articles;

    @PostConstruct
    public void init() {
        loadAllTeams();
    }

    @Transactional
    public void createArticle(){
        this.articleDAO.persist(articleToCreate);
    }
    private void loadAllTeams() {
        this.articles = articleDAO.getAll();
    }
}