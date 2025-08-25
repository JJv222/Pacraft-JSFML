package logger;

public enum LoggerLevel {
   INFO, DEBUG, ERROR;

   @Override
   public String toString() {
      return name().toUpperCase();
   }
}
