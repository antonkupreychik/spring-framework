package com.javarush.context.lesson1;

import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDao {

    Log log = LogFactory.getLog(UserDao.class);

    private final DataSource dataSource;

    @Autowired
    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User findById(Integer id) {
        try (Connection connection = dataSource.getConnection()) { // (2)
            PreparedStatement selectStatement = connection.prepareStatement("select * from users where id =  ?");
            selectStatement.setInt(1, id);
            return buildUserFromStatement(selectStatement);
        } catch (SQLException e) {
            log.error("Error while getting user by id", e);
            throw new RuntimeException(e);
        }
    }

    public User findByFirstName(String firstName) {
        try (Connection connection = dataSource.getConnection()) { // (2)
            PreparedStatement selectStatement = connection.prepareStatement("select * from users where name =  ?");
            selectStatement.setString(1, firstName);
            return buildUserFromStatement(selectStatement);
        } catch (SQLException e) {
            log.error("Error while getting user by first name", e);
            throw new RuntimeException(e);
        }
    }

    private User buildUserFromStatement(PreparedStatement selectStatement) throws SQLException {
        ResultSet resultSet = selectStatement.executeQuery();
        if (resultSet.next()) {
            return User.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .build();
        } else
            return null;
    }


}



/*
 private final DataSource dataSource;

    public UserDao(DataSource dataSource) { // (1)
        this.dataSource = dataSource;
    }

    public User findById(Integer id) {
        try (Connection connection = dataSource.getConnection()) { // (2)
            PreparedStatement selectStatement = connection.prepareStatement("select * from users where id =  ?");
            selectStatement.setInt(1, id);
            return buildUserFromStatement(selectStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User findByFirstName(String firstName) {
        try (Connection connection = dataSource.getConnection()) { // (2)
            PreparedStatement selectStatement = connection.prepareStatement("select * from users where name =  ?");
            selectStatement.setString(1, firstName);
            return buildUserFromStatement(selectStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User buildUserFromStatement(PreparedStatement selectStatement) throws SQLException {
        ResultSet resultSet = selectStatement.executeQuery();
        if (resultSet.next()) {
            return User.builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .build();
        } else
            return null;
    }
 */
