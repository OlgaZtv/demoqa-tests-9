package guru.qa.apiConfig;


import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/tmp/token.properties",
        "classpath:token.properties"
})
public interface ApiConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://github.com/olgaZtv")
    String baseUrl();

    @Key("token")
    String token();

}