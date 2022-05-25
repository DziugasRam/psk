package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.User;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.USER
     *
     * @mbg.generated Wed May 25 10:34:57 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.USER
     *
     * @mbg.generated Wed May 25 10:34:57 EEST 2022
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.USER
     *
     * @mbg.generated Wed May 25 10:34:57 EEST 2022
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.USER
     *
     * @mbg.generated Wed May 25 10:34:57 EEST 2022
     */
    List<User> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.USER
     *
     * @mbg.generated Wed May 25 10:34:57 EEST 2022
     */
    int updateByPrimaryKey(User record);
}