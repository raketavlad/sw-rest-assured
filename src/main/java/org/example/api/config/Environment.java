package org.example.api.config;

public enum Environment {
    TESTING,
    STAGING,
    PROD;

    public static Environment getProposedEnvironment() {
        String targetEnv = System.getProperty("env");

        if (targetEnv == null) {
            return TESTING;
        }

        switch (targetEnv.toLowerCase().trim()) {
            case "staging":
                return STAGING;
            case "prod":
                return PROD;
            default:
                return TESTING;
        }
    }
}