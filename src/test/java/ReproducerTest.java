import java.io.IOException;
import java.security.GeneralSecurityException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GitHubBuilder;
import org.kohsuke.github.authorization.AppInstallationAuthorizationProvider;
import org.kohsuke.github.extras.authorization.JWTTokenProvider;
import io.jsonwebtoken.Jwts;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReproducerTest {

    @Test
    void reproduce() throws GeneralSecurityException, IOException {
        // this works
        var builder = Jwts.builder().setIssuedAt(null);
    assertNotNull(builder);
    System.out.println("I RAN");
        // this doesn't
        var gh =
                new GitHubBuilder()
                        .withAuthorizationProvider(
                                new AppInstallationAuthorizationProvider(
                                        app -> app.getInstallationById(Integer.parseInt(Constants.APP_INSTALLATION_ID)),
                                        new JWTTokenProvider(Constants.APP_ID, Constants.APP_PRIVATE_KEY)))
                        .build();
        // when jjwt works, the call would result in an http exception (because of a wrong web token), such exception is ok in our reproduction case
        assertThrows(org.kohsuke.github.HttpException.class, gh::getApp);
    }

}
