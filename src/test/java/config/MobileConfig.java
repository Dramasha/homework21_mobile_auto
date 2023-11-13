package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface MobileConfig extends Config {
    @Key("appUrl")
    String getApp();

    @Key("device")
    @DefaultValue("Samsung S21")
    String getDevice();

    @Key("os_version")
    @DefaultValue("12.0")
    String getVersion();
}