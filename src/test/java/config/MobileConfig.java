package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface MobileConfig extends Config {
    @Key("appUrl")
    String getApp();

    @Key("device")
    @DefaultValue("Samsung A52")
    String getDevice();

    @Key("os_version")
    @DefaultValue("11.0")
    String getVersion();
}