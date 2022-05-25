package lt.vu.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "REVIEW")
@Getter
@Setter
@EqualsAndHashCode(of={"content"})
public class Review {

    @EmbeddedId
    ReviewKey id = new ReviewKey();

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("articleId")
    @JoinColumn(name = "article_id")
    Article article = new Article();

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user = new User();

    private Integer rating;

    @Column(name = "content", nullable=false)
    private String content;
}
