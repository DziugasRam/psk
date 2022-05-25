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
@NamedQueries({
        @NamedQuery(name = "User.getAll", query = "select u from User as u")
})
@Table(name = "USER")
@Getter
@Setter
@EqualsAndHashCode(of={"name"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable=false)
    private String name;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    private List<Article> articles = new ArrayList<Article>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Review> reviews = new ArrayList<Review>();
}
