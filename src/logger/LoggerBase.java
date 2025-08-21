package logger;

public interface LoggerBase {
   void log(final LoggerLevel level,String message);
   //Map
   String MAP_CACHE_NOT_FOUND = "Texture %s not found in the cache !";
   String MAP_INIT_START = "Inizicializing map..";
   String MAP_INIT_END  = "Map Inicizalized sucesfully!";
   String MAP_INIT_ERROR = "Map Inicilization failure!!";
   //TextureUtils
}
