package utils;

import logger.LoggerUtils;
import org.jsfml.graphics.Texture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextureUtils extends ResourcePath {
   public static final Map<String, Texture> TEXTURES;
   protected static final String TEXTURE_PATH = "Textures";

   static {
      logger = LoggerUtils.getLogger(TextureUtils.class);
      try {
         logger.info(LoggerUtils.TEXTURE_LOADING_START);
         Set<String> textureFiles = listFilesUsingFilesList(PATH_BASE + "/Textures");
         TEXTURES = new HashMap<>();
         for (String fileName : textureFiles) {
            try {
               Texture texture = new Texture();
               texture.loadFromFile(Paths.get(createPath(TEXTURE_PATH, fileName)));
               TEXTURES.put(fileName, texture);
               logger.info(String.format(LoggerUtils.TEXTURE_LOADING_SUCCESS, fileName));
            } catch (IOException e) {
               logger.severe(String.format(LoggerUtils.TEXTURE_LOADING_ERROR, fileName));
            }
         }
         logger.info(LoggerUtils.TEXTURE_LOADING_COMPLETE);
      } catch (IOException e) {
         logger.severe("Cannot load textures: " + e.getMessage());
         throw new RuntimeException("Cannot load textures", e);
      }
   }

   public static Set<String> listFilesUsingFilesList(String path) throws IOException {
      try (Stream<Path> stream = Files.list(Paths.get(path))) {
         return stream
            .filter(file -> !Files.isDirectory(file))
            .map(Path::getFileName)
            .map(Path::toString)
            .collect(Collectors.toSet());
      }
   }
}
