package at.study.automation.db.connection;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class PostgresConnection implements DataBaseConnection{

    public final static DataBaseConnection INSTANCE = new PostgresConnection();

    private String host = "edu-at.dfu.i-teco.ru";
    private Integer port = 5432;
    private String dataBase = "db";
    private String user = "redmine_user";
    private String password = "redmine_pass";
    private Connection connection;

    public PostgresConnection() {
    connect();
    }


    @SneakyThrows
    public void connect() {
        Class.forName("org.postgresql.Driver");

        String url = String.format("jdbc:postgresql://%s:%d/%s", host, port, dataBase);
        Properties connectionProperties = new Properties();
        connectionProperties.setProperty("user", user);
        connectionProperties.setProperty("password", password);
        connection = DriverManager.getConnection(url, connectionProperties);

}

    @Override
    @SneakyThrows
    public List<Map<String, Object>> executeQuery(String query, Object... parameters) {
        // Select * from users Where id = ? and hashpassword = ?


        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i+1, parameters[i]);
        }

        ResultSet rs = statement.executeQuery(query);

        List<Map<String, Object>> result = new ArrayList<>();


        while (rs.next()) {
            Map<String, Object> oneResult = new TreeMap<>();
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String key = rs.getMetaData().getColumnName(i);
                Object value = rs.getObject(i);
                oneResult.put(key, value);

            }
            result.add(oneResult);
        }
        return result;
    }
}