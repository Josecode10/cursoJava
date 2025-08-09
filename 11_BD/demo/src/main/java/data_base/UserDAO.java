package data_base;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserDAO {
    // DAO: Data Access Object
    private final String url = "jdbc:mysql://localhost:3306/mydb";
    private final String user = "root";
    private final String password = "admin";

    private Connection connect() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void createUser(String name, String lastName, String email) {
        String sql = "INSERT INTO users (name, lastName, email) VALUES (?, ?, ?)";
        try {

        }
    }


}
