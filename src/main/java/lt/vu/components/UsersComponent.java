package lt.vu.components;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Article;
import lt.vu.entities.User;
import lt.vu.persistence.ArticleDAO;
import lt.vu.persistence.UserDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@Model
public class UsersComponent {
    @Inject
    private UserDAO userDAO;

    @Getter
    @Setter
    private User userToCreate = new User();

    @Getter
    private List<User> users;

    @PostConstruct
    public void init() {
        loadAllTeams();
    }

    @Transactional
    public void createUser(){
        this.userDAO.persist(userToCreate);
    }

    public void generateNumber(){

    }

    private void loadAllTeams() {
        this.users = userDAO.getAll();
    }
}