package map;

import logger.LoggerLevel;
import map.base.MapBase;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

import java.util.ArrayList;
import java.util.List;

import static logger.LoggerBase.*;

public final class GameMap extends MapBase {
   public GameMap(int height, int width, DifficultyLevel level) {
      super(height, width, level);
   }

   @Override
   protected List<List<Character>> initMap() {
      List<String> sketch = List.of(
         "!###################!",
         "!#?.E?...?X?..X?E.?#!",
         "!#.##.###.#.###.##.#!",
         "!#?X.?.?X?#?.?.?..?#!",
         "!#.##.#.#####.#.##.#!",
         "!#?..?#?.?#?.?#?.X?#!",
         "!####.###.#.###.####!",
         "!!!!#.#?H???X?#.#!!!!",
         "#####.#X##D## #.#####",
         "     ? ?#???#?K?     ",
         "#####X# ##D## #.#####",
         "!!!!#.#? P?B ?#X#!!!!",
         "!####.#.#####.#.####!",
         "!#?X.?.?.?#?.?X?..?#!",
         "!#.##.###.#.###.##.#!",
         "!#?..?X?.?.?.?.?#??#!",
         "!#.##.#.#####.#.#.##!",
         "!#?.??#?.?#?.?#?X??#!",
         "!#.#.####.#.###.##.#!",
         "!#?E?X...?.?..X?.E?#!",
         "!###################!"
      );
      return sketch.stream()
         .map(row -> row.chars().mapToObj(c -> (char) c).toList())
         .toList();
   }

   @Override
   protected List<List<Sprite>> createSpriteMap(int height, int width, DifficultyLevel level, List<List<Character>> characterMap) {
      List<List<Sprite>> result = new ArrayList<>();
      logger.log(LoggerLevel.INFO, MAP_INIT_START);

      for (int y = 0; y < characterMap.size(); y++) {
         List<Sprite> row = new ArrayList<>();
         for (int x = 0; x < characterMap.get(y).size(); x++) {
            String texturePath = CharMapToTextureName(characterMap.get(y).get(x));
            row.add(addSprite(texturePath, new Vector2f(x, y)));
         }
         result.add(row);
      }
      logger.log(LoggerLevel.INFO, MAP_INIT_END);
      return result;
   }

   public String CharMapToTextureName(final char character) {
      return switch (character) {
         case '#' -> "wall.png";
//         case '.' -> "path.png";
//         case 'P' -> "steve.jpg";
//         case 'D' -> "drzwi.png";
//         case 'X' -> "dziura.png";
//         case 'E' -> "energizer.png";
//         case 'B' -> "blaze.png";
//         case 'H' -> "zoombie.png";
//         case 'K' -> "creeper.jpg";
//         case '?' -> "corn.png";
         case '!' -> "blackBox.png";
//         case ' ' -> "path.png";
         default -> "path.png";
      };
   }
}
