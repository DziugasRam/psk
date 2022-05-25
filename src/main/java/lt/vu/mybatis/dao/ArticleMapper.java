package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Article;

public interface ArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ARTICLE
     *
     * @mbg.generated Wed May 25 10:34:57 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ARTICLE
     *
     * @mbg.generated Wed May 25 10:34:57 EEST 2022
     */
    int insert(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ARTICLE
     *
     * @mbg.generated Wed May 25 10:34:57 EEST 2022
     */
    Article selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ARTICLE
     *
     * @mbg.generated Wed May 25 10:34:57 EEST 2022
     */
    List<Article> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ARTICLE
     *
     * @mbg.generated Wed May 25 10:34:57 EEST 2022
     */
    int updateByPrimaryKey(Article record);
}