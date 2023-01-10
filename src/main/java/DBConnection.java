import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class DBConnection {
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432";

    protected Connection getDBConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(true);
            log.info("Соединение установлено");
        } catch (ClassNotFoundException e) {
            log.debug("Драйвер не найден");
        } catch (SQLException e) {
            log.debug(String.format("Ошибка при подключении к базе данных: %s", e.getMessage()));
        }
        return connection;
    }
}
