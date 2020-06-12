package DAY9;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class Connector {
    private final String url = "jdbc:mysql://localhost:3306/megaapp" +
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";

    public Connection connection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, "root", "");
        return connection;
    }
}