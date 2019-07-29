package com.spring.annotation.db.dao.impl;

import com.spring.annotation.db.dao.IUserDao;
import com.spring.annotation.db.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String INSERT_SQL = "insert into test(name) values(:myName)";
    private static final String COUNT_ALL_SQL = "select count(*) from test";

    @Override
    public void save(User model) {
        jdbcTemplate.update(INSERT_SQL, new BeanPropertySqlParameterSource(model));
    }

    @Override
    public int countAll() {
        return jdbcTemplate.update(COUNT_ALL_SQL);
    }

    @Override
    public int add(User user) {
        String sql = "INSERT INTO user(id,name,sex) VALUES (?,?,?)";
        int add = jdbcTemplate.update(sql, user.getId(), user.getName(), user.getSex());
        return add;
    }

    @Override
    public int delete(Integer uid) {
        String sql = "DELETE FROM user where id = ?";
        int delete = this.jdbcTemplate.update(sql, uid);
        return delete;
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE user SET name=?,sex=? where id=?";
        int update = jdbcTemplate.update(sql, user.getName(), user.getSex(), user.getId());
        return update;
    }

    @Override
    public List<User> getAll() {
        String sql = "select *from t_user";
        /*List<User> query = jdbcTemplate.query(sql, new RowMapper<User>() {*/
        List<User> query = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSex(resultSet.getString("sex"));
                return user;
            }
        });
        return query;
    }

    @Override
    public User getById(Integer id) {
        String sql = "select * from t_user where uid = ?";
        User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Nullable
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("uid"));
                user.setName(resultSet.getString("name"));
                user.setSex(resultSet.getString("sex"));
                return user;
            }
        }, id);
        return user;
    }

}
