import com.codeup.adlister.dao.Config;
import java.sql.SQLException;

public class DaoFactory {
    private static Ads adsDao;
    public static Config testConfig = new Config();

    public static Ads getAdsDao() throws SQLException {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(testConfig);
        }
        return adsDao;
    }
}
