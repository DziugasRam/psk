package lt.vu.components;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Article;
import lt.vu.entities.Review;
import lt.vu.entities.User;
import lt.vu.persistence.ArticleDAO;
import lt.vu.persistence.UserDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class ArticleComponent implements Serializable {
    @Inject
    private ArticleDAO articleDAO;
    @Inject
    private UserDAO userDAO;

    @Getter
    @Setter
    private Article article;

    @Getter
    @Setter
    private Integer authorToAddId;

    @Getter
    @Setter
    private Review reviewToCreate = new Review();

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer articleId = Integer.parseInt(requestParameters.get("articleId"));
        this.article = articleDAO.findOne(articleId);
    }

    @Transactional
    public String addAuthor() {
        User user = userDAO.findOne(authorToAddId);
        article.getAuthors().add(user);
        articleDAO.update(this.article);
        return "article?faces-redirect=true&articleId=" + article.getId().toString();
    }

    @Transactional
    public String createReview() {
        User user = userDAO.findOne(reviewToCreate.getUser().getId());
        reviewToCreate.setUser(user);
        reviewToCreate.setArticle(article);
        article.getReviews().add(reviewToCreate);
        articleDAO.update(this.article);
        return "article?faces-redirect=true&articleId=" + article.getId().toString();
    }

    @Transactional
    public String updateArticle() {
        try {
            articleDAO.update(this.article);
            return "article?faces-redirect=true&articleId=" + article.getId().toString();
        } catch (OptimisticLockException e) {
            return "article?faces-redirect=true&articleId=" + article.getId().toString() + "&exception=optimistic-lock-exception";
        }
    }
}
