package lt.vu.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ARTICLE")
@NamedQueries({@NamedQuery(name = "Article.getAll", query = "SELECT a FROM Article a")})
@Getter
@Setter
@EqualsAndHashCode(of = {"title"})
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;
    private String content;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "article_authors", joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> authors = new ArrayList<User>();

    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<Review>();

    @Version
    private Integer version;
}
