package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobileConfig;
import config.UserConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());
        UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());

        MutableCapabilities mutableCapabilities = new MutableCapabilities();

        mutableCapabilities.setCapability("browserstack.user", userConfig.getUserName());
        mutableCapabilities.setCapability("browserstack.key", userConfig.getPassword());

        mutableCapabilities.setCapability("app", mobileConfig.getApp());

        mutableCapabilities.setCapability("device", mobileConfig.getDevice());
        mutableCapabilities.setCapability("os_version", mobileConfig.getVersion());

        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        try {
            return new RemoteWebDriver(
                    new URL(userConfig.getRemoteUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
