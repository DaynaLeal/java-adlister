import com.codeup.adlister.dao.Config;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
    }

    @Override
    public List<Ad> all() {
        Statement stmt = null;
        List<Ad> ads = new ArrayList<>();
        try{
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
            while (rs.next()){
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
            return ads;
        } catch(SQLException sqle){
            throw new RuntimeException("Error retrieving ads", sqle);
        }
    }

    @Override
    public Long insert(Ad ad) {
        Statement stmt = null;
        String query = String.format("INSERT INTO ads(title, description) " + "VALUES (%s, %s)", ad.getTitle(), ad.getDescription());
        try{
            stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            return rs.getLong(1);
        } catch (SQLException sqle){
            throw new RuntimeException("Error inserting into ads", sqle);
        }
    }
}
