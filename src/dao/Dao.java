package Practice.InsuranceCompany.Design.src.dao;

import java.sql.*;

public class Dao {
    private Connection connect=null;
    private Statement statement=null;
    private ResultSet resultSet=null;

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance?useSSL=false", "root", "seoyeon001!");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public PreparedStatement connectPrepareStatement(String query){
        try {
            return connect.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean create(String query){
        try {
            statement = connect.createStatement();
            return !statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean create(PreparedStatement pstmt){
        try {
            return pstmt.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(String query) {
        try {
            statement = connect.createStatement();
            return !statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean update(String query) {
        try {
            statement = connect.createStatement();
            return !statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet retrieve(String query) {
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
