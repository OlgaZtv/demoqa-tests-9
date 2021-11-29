package guru.qa.tests.properties;

import guru.qa.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class OwnerTests {
    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @Test
    void readCredentialsTest() {
        String login = credentials.login();
        String password = credentials.password();

        System.out.println(login);
        System.out.println(password);

        String message = format("I login as %s with password %s", login, password);
        System.out.println(message);
    }
}
