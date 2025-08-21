package logger;

import java.util.Objects;

public final class Logger implements LoggerBase {
   final String className;
   final LoggerLevel level;

   public Logger(Class object) {
      level = LoggerLevel.ERROR;
      this.className = object.getSimpleName();
   }

   @Override
   public void log(LoggerLevel level, String message) {
      System.out.printf("%s | %s | %s%n", className, level, message);
   }
}
