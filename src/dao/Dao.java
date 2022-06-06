package Practice.InsuranceCompany.Design.src.dao;

import java.sql.*;

public class Dao {

    protected static String dq = "\"";
    protected Connection connect=null;
    protected Statement statement=null;
    protected ResultSet resultSet=null;

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "seoyeon001!");
        } catch (SQLException | ClassNotFoundException e) {
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
