package logger;

public enum LoggerLevel {
   INFO,ERROR;

   @Override
   public String toString() {
      return name().toUpperCase();
   }
}
