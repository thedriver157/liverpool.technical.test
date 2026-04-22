package com.liverpool.Utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvVars {
    private static Dotenv dotenv;

    private static void loadVars() {
        dotenv = Dotenv.configure()
                .directory("../")
                .filename(".env")
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
    }

    private static String cleanQuote(String var) {
        return var.replaceAll("^['\"]|['\"]$", "");
    }

    public static String getEnvVar(String key) {
        if (dotenv == null) {
            EnvVars.loadVars();
        }

        return cleanQuote(dotenv.get(key));
    }
}