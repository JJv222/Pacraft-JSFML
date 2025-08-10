package logger;

public final class Logger implements LoggerConstants {
   final String className;

   public Logger(Class object) {
      this.className = object.getSimpleName();
   }

   public void createErrorMessage(final LoggerLevel level , final String message) {
      System.out.printf("%s | %s | %s%n", className, level, message);
   }

}
