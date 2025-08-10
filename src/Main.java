import map.DifficultyLevel;
import map.GameMap;
import map.base.MapBase;
import map.MapConstants;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import java.util.List;

public class Main {
   public static void main(String[] args) {
      RenderWindow window = new RenderWindow();
      window.create(new VideoMode(MapConstants.WINDOW_WIDTH, MapConstants.WINDOW_HIGH), "Pacraft"); // Zwiększam rozmiar okna dla mapy 21x21 (50px * 21)
      window.setFramerateLimit(60);

      final MapBase map = new GameMap(21, 21, DifficultyLevel.EASY);

      while (window.isOpen()) {
         for (Event event : window.pollEvents()) {
            if (event.type == Event.Type.CLOSED) {
               window.close();
            }
         }

         window.clear(Color.BLACK);
         for (List<Sprite> sprites : map.getSpriteMap()) {
            for (Sprite sprite : sprites) {
               window.draw(sprite);
            }
         }

         window.display();
      }
   }
}