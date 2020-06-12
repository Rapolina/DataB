package DAY9;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DataB {
    private static final String DELETE_TABLE = "DROP TABLE IF EXISTS users";
    private static final String CREATE_TABLE = "CREATE TABLE users (user_id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY," +
            "user_login VARCHAR(255)," +
            "user_password CHAR(40))";
    private static final String CREATE_USER = "INSERT INTO users (user_login, user_password) VALUES (?, ?)";
    private static final String SELECT = "SELECT * FROM users";
    Connector connect = new Connector();
    Generator generator = new Generator();

    public void deleteTable() {
        try (PreparedStatement statement = connect.connection().prepareStatement(DELETE_TABLE)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try (PreparedStatement statement = connect.connection().prepareStatement(CREATE_TABLE)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUsers() {
        int count = 0;
        try (PreparedStatement statement = connect.connection().prepareStatement(CREATE_USER)) {

            while (count < 10){
                statement.setString(1, generator.generateRandomLogin());
                statement.setString(2, generator.generateRandomPassword());
                statement.executeUpdate();
                count++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void read() {
        List<Users> users = new ArrayList<>();

        try (PreparedStatement statement = connect.connection().prepareStatement(SELECT);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                users.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        users.forEach(user -> System.out.println(user.toString()));
    }
}