package com.esquinaweb.config;

import com.esquinaweb.model.WindowConfig;

public class ConfigManager {
	
    private final WindowConfig config;

    public ConfigManager() {

        config = new WindowConfig();

    }

    public WindowConfig getConfig() {

        return config;

    }
    
}
