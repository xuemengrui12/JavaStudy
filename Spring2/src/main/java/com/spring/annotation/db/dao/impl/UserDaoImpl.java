package com.spring.annotation.db.dao.impl;

import com.spring.annotation.db.dao.IUserDao;
import com.spring.annotation.db.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao {

    private static final String INSERT_SQL = "INSERT INTO user (id,name,sex) VALUES (?,?,?)";
    private static final String GET_ALL_SQL = "select * from 'user'";
    private static final String DELETE_SQL = "DELETE FROM 'user' where id = ?";
    private static final String UPDATE_SQL = "UPDATE 'user' SET name=?,sex=? where id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User user) {
        int add = jdbcTemplate.update(INSERT_SQL, user.getId(), user.getName(), user.getSex());
        return add;
    }

    @Override
    public int delete(Integer uid) {
        String sql = DELETE_SQL;
        int delete = jdbcTemplate.update(sql, uid);
        return delete;
    }

    @Override
    public int update(User user) {
        String sql = UPDATE_SQL;
        int update = this.jdbcTemplate.update(sql, user.getName(), user.getSex(), user.getId());
        return update;
    }

    @Override
    public List<User> getAll() {
        String sql = GET_ALL_SQL;
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
        String sql = "select * from user where uid = ?";
        User user = this.jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
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
