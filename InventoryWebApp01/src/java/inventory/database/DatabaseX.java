package inventory.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseX {
    
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sakila"
                + "?autoReconnect=true"
                + "&useUnicode=true"
                + "&useSSL=false"
                + "&useJDBCCompliantTimezoneShift=true"
                + "&useLegacyDatetimeCode=false"
                + "&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456";
    
    private Connection m_CConnection;
    private Statement m_CStatement;
    private ResultSet m_CResultSet;
    
    public DatabaseX() {
        setConnection(createConnection());
        setStatement(createStatement());
    }

    public Connection getConnection() {
        return m_CConnection;
    }

    public void setConnection(Connection p_CConnection) {
        m_CConnection = p_CConnection;
    }

    public Statement getStatement() {
        return m_CStatement;
    }

    public void setStatement(Statement p_CStatement) {
        m_CStatement = p_CStatement;
    }

    public ResultSet getResultSet() {
        return m_CResultSet;
    }

    public void setResultSet(ResultSet p_CResultSet) {
        m_CResultSet = p_CResultSet;
    }
    
    private Connection createConnection() {
        Connection connection = null;
        
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseX.class.getName()).log(Level.SEVERE, null, ex);
        } return connection;
    }
    
    private Statement createStatement() {
        Connection connection = getConnection();
        Statement statement = null;
        
        try {
            if(!connection.isClosed()) {
                statement = connection.createStatement();
            }
        } catch(SQLException ex) {
            Logger.getLogger(DatabaseX.class.getName()).log(Level.SEVERE, null, ex);
        } return statement;
    }
    
    public ResultSet executeQuery(String p_strSql) {
        Connection connection = getConnection();
        Statement statement = getStatement();
        ResultSet result = null;
        
        try {
            if(!connection.isClosed()) {
                result = statement.executeQuery(p_strSql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseX.class.getName()).log(Level.SEVERE, null, ex);
        } setResultSet(result);
        
        return result;
    }
    
    public int executeNonQueryRows(String p_strSql) {
        Connection connection = getConnection();
        Statement statement = getStatement();
        int iRows = 0;
        
        try {
            if(!connection.isClosed()) {
                iRows = statement.executeUpdate(p_strSql);
            }
        } catch (SQLException ex)  {
            Logger.getLogger(DatabaseX.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return iRows;
    }
    
}