package helpers;

import config.UserConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

        protected static final UserConfig config = ConfigFactory.create(UserConfig.class, System.getProperties());

        public static String videoUrl(String sessionId) {
            String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

            return given()
                    .auth().basic(config.getUserName(), config.getPassword())
                    .when()
                    .get(url)
                    .then()
                    .log().all()
                    .statusCode(200)
                    .extract().path("automation_session.video_url");

    }

}
