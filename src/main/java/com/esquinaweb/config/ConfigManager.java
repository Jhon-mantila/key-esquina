package com.esquinaweb.config;

import com.esquinaweb.model.WindowConfig;

import java.util.prefs.Preferences;

public class ConfigManager {

    private static final String ALWAYS_ON_TOP = "alwaysOnTop";
    private static final String OPACITY = "opacity";

    private final WindowConfig config;

    private final Preferences preferences = Preferences.userNodeForPackage(ConfigManager.class);

    public ConfigManager() {

        config = new WindowConfig();
        config.setAlwaysOnTop(preferences.getBoolean(ALWAYS_ON_TOP, config.isAlwaysOnTop()));
        config.setOpacity(preferences.getDouble(OPACITY, config.getOpacity()));

    }

    public WindowConfig getConfig() {

        return config;

    }

    public void save() {

        preferences.putBoolean(ALWAYS_ON_TOP, config.isAlwaysOnTop());
        preferences.putDouble(OPACITY, config.getOpacity());

    }
}
