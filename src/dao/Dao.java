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

    public void create(String query){
        try {
            statement = connect.createStatement();
            if(!statement.execute(query)) System.out.println("insert OK!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(PreparedStatement pstmt){
        try {
            if(pstmt.executeUpdate()!=0) System.out.println("insert OK!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String query) {
        try {
            statement = connect.createStatement();
            if (!statement.execute(query)) System.out.println("delete OK!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(String query) {
        try {
            statement = connect.createStatement();
            if (!statement.execute(query)) System.out.println("update OK!");
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
