package utils;

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
   private static String TEXTURE_PATH = "Textures";

   static {
      try {
         Set<String> textureFiles = listFilesUsingFilesList(PATH_BASE + "/Textures");
         TEXTURES = new HashMap<>();
         for (String fileName : textureFiles) {
            try {
               Texture texture = new Texture();
               texture.loadFromFile(Paths.get(createPath(TEXTURE_PATH, fileName)));
               TEXTURES.put(fileName, texture);
            } catch (IOException e) {
              // System.err.println("Błąd ładowania tekstury " + fileName + ": " + e.getMessage());
            }
         }

      } catch (IOException e) {
       //  System.err.println("Błąd podczas listowania plików tekstur: " + e.getMessage());
         throw new RuntimeException("Nie można załadować tekstur", e);
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
