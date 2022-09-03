package conecction;
import java.sql.*;
import java.util.Properties;

public class conection {
    
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    
}
