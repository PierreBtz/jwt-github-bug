
import io.github.cdimascio.dotenv.Dotenv;

public class Constants {
    private static final Dotenv DOTENV;

    static {
        DOTENV = Dotenv.load();
    }

    public static final String APP_INSTALLATION_ID = DOTENV.get("JWT_GH_BUG_APP_INSTALLATION_ID");
    public static final String APP_ID = DOTENV.get("JWT_GH_BUG_APP_ID");
    public static final String APP_PRIVATE_KEY = DOTENV.get("JWT_GH_BUG_APP_PRIVATE_KEY");
}
