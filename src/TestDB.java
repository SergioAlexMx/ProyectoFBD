import java.sql.*;

public class TestDB {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:49161:XE", "fbd_1", "dummy");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from artistas");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

