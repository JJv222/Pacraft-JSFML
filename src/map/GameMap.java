package map;

import map.base.MapBase;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;
import logger.LoggerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public final class GameMap extends MapBase {
   private Character[][] coinMap;

   public GameMap(int height, int width, DifficultyLevel level) {
      super(height, width, level);
   }

   @Override
   protected Character[][] initMap() {
      String[] sketch = {
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
      };
      final Character[][] map = new Character[sketch.length][sketch[0].length()];
      setCoinMap(sketch,map);
      return map;
   }

   @Override
   protected List<List<Sprite>> createSpriteMap(int height, int width, DifficultyLevel level, Character[][] characterMap) {
      List<List<Sprite>> result = new ArrayList<>();
      logger.log(Level.INFO, LoggerUtils.MAP_INIT_START);

      for (int y = 0; y < characterMap.length; y++) {
         List<Sprite> row = new ArrayList<>();
         for (int x = 0; x < characterMap[y].length; x++) {
            String texturePath = CharMapToTextureName(characterMap[y][x]);
            row.add(addSprite(texturePath, new Vector2f(x, y)));
         }
         result.add(row);
      }
      logger.log(Level.INFO, LoggerUtils.MAP_INIT_END);
      return result;
   }

   private String CharMapToTextureName(final char character) {
      return switch (character) {
         case '#' -> "wall.png";
         case 'D' -> "drzwi.png";
         case '!' -> "blackBox.png";
         default -> "path.png";
      };
   }

   private void setCoinMap(final String[] sketch,  Character[][] map ){
      coinMap = new Character[sketch.length][sketch[0].length()];
      for (int y = 0; y < sketch.length; y++) {
         for (int x = 0; x < sketch[y].length(); x++) {
            final char element = sketch[y].charAt(x);
            map[y][x] = element;
            if(element == '.'){
               coinMap[y][x] = element;
            }
         }
      }
   }
}
