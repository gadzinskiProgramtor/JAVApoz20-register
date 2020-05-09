package pl.sda.register.dao;


import org.springframework.stereotype.Repository;
import pl.sda.register.config.DbConnection;
import pl.sda.register.exception.DuplicatedUserNameException;
import pl.sda.register.exception.UserNotFoundException;
import pl.sda.register.model.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {

    private static UserDaoImpl instance;

    private UserDaoImpl() {
    }

    public static  UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }

        return instance;
    }


    @Override
    public Set<String> findAllUserNames() {

        String selectSQL = "SELECT username FROM users";
        Set<String> userSet = new HashSet<>();

        try (Connection dbConnection = DbConnection.getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                String userName = rs.getString("username");


                userSet.add(userName);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return userSet;


    }

    @Override
    public Set<String> findAllUserNames(String firstName, Boolean matchExact) {
        Set<String> userSet = new HashSet<>();
        String selectSQL;
        if (matchExact) {
            selectSQL = "SELECT u.username FROM users u where firstName =?";
        } else {
            selectSQL = "SELECT u.username  FROM users u where firstName like ?";
        }


        try (Connection dbConnection = DbConnection.getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            if (matchExact) {
                preparedStatement.setString(1, firstName);
            } else {
                preparedStatement.setString(1, "%" + firstName + "%");
            }

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                String userName = rs.getString("username");


                userSet.add(userName);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return userSet;
    }

    @Override
    public User findUserByUsername(String username) {
        String selectSQL = "SELECT * FROM users where username =?";

        try (Connection dbConnection = DbConnection.getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                String userName = rs.getString("username");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");

                return new User(userName, firstName, lastName);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        throw new UserNotFoundException("User with username: " + username + " not found");
    }

    @Override
    public void addUser(User user) {
        if (isUserPresent(user.getUsername())) {
            String selectSQL = "INSERT INTO users (username, firstName, lastName) VALUE (?,?,?)";

            try (Connection dbConnection = DbConnection.getDBConnection();
                 PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getLastName());

                preparedStatement.execute();


            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else {
        throw new DuplicatedUserNameException(user.getUsername());}
    }

    @Override
    public boolean isUserPresent(String username) {
        String selectSQL = "SELECT username FROM users where username =?";

        try (Connection dbConnection = DbConnection.getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            if (!rs.next()) {

                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void removeUser(String username) {
        String selectSQL = "Delete from users where username = ?";

        try (Connection dbConnection = DbConnection.getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, username);
            preparedStatement.execute();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateUser(User user) {
        String selectSQL = "UPDATE users SET firstName=?, lastName=?  WHERE username = ?";

        try (Connection dbConnection = DbConnection.getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
