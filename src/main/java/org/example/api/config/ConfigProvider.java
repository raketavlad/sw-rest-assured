package org.example.api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProvider {
    private static final Properties properties = new Properties();

    public static final String BASE_URL;
    public static final int TIMEOUT;

    static {
        Environment currentEnv = Environment.getProposedEnvironment();

        String configFileName = currentEnv.name().toLowerCase() + ".properties";

        try (InputStream input = ConfigProvider.class.getClassLoader().getResourceAsStream(configFileName)) {
            if (input == null) {
                throw new RuntimeException("Не удалось найти файл конфигурации: " + configFileName);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при загрузке конфигурации", e);
        }

        BASE_URL = requireProperty("base.url", configFileName);
        TIMEOUT = Integer.parseInt(properties.getProperty("api.timeout", "5000"));
    }

    private static String requireProperty(String key, String configFileName) {
        String value = properties.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Обязательный параметр '" + key + "' не найден в " + configFileName);
        }
        return value;
    }
}