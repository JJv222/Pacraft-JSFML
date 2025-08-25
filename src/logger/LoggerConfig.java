package logger;

import java.util.logging.*;

public class LoggerConfig {
   public static final String MAP_CACHE_NOT_FOUND = "Texture %s not found in the cache !";
   public static final String MAP_INIT_START = "Initializing map..";
   public static final String MAP_INIT_END = "Map Initialized successfully!";

   public static void setup(LoggerLevel level) {
      Logger rootLogger = Logger.getLogger("");
      rootLogger.setLevel(convertLevel(level));
   }

   public static Logger getLogger(final Class<?> clazz) {
      return Logger.getLogger(clazz.getName());
   }

   private static Level convertLevel(LoggerLevel level) {
      return switch (level) {
         case INFO -> Level.INFO;
         case DEBUG -> Level.FINE;
         case ERROR -> Level.SEVERE;
      };
   }
}
