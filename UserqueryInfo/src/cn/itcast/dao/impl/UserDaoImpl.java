package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author QLBF
 * @version 1.0
 * @date 2020/11/28 10:05
 */
public class UserDaoImpl implements UserDao{
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
    /**
     * @description:  如果查到就返回一个User对象的列表
     * @param: * @param:
     * @return: java.util.List<cn.itcast.domain.User>
     * @author QLBF
     * @date: 2020/11/28 10:09
     */
        //使用JDBC操作数据库...
        //1.定义sql，若sql查不到就会抛出异常，不用担心
        String sql="select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
}
