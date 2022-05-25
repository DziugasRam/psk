package lt.vu.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReviewKey implements Serializable {
    @Column(name = "article_id")
    private Integer articleId;
    @Column(name = "user_id")
    private Integer userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewKey reviewKey = (ReviewKey) o;
        return articleId.equals(reviewKey.articleId) && userId.equals(reviewKey.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, userId);
    }
}
