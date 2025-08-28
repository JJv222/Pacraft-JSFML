package utils;

import java.util.Arrays;
import java.util.logging.Logger;

abstract class ResourcePath {
   protected static final String PATH_BASE = "src/utils";
   protected static final String PATH = PATH_BASE + "/";
   protected static Logger logger;

   protected static String createPath(String... args) {
      final StringBuilder builder = new StringBuilder(Arrays.stream(args).toList().size())
         .append(PATH_BASE);
      for (String variable : args) {
         builder.append("/");
         builder.append(variable);
      }
      return builder.toString();
   }
}
