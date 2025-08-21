import map.DifficultyLevel;
import map.GameMap;
import map.MapConstants;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import java.util.List;

public class Game {
   private final RenderWindow window;
   private final int frameLimit;
   private final DifficultyLevel level;
   private final GameMap map;
   private final String title;

   public Game(String title, int frameLimit, DifficultyLevel level, int height, int weight) {
      this.title = title;
      this.window = new RenderWindow();  // Zwiększam rozmiar okna dla mapy 21x21 (50px * 21)
      window.create(new VideoMode(MapConstants.WINDOW_WIDTH, MapConstants.WINDOW_HIGH),title );
      this.frameLimit = frameLimit;
      this.level = level;
      this.map = new GameMap(height,weight,level);
   }

   public void run(){
      window.setFramerateLimit(frameLimit);

      while(window.isOpen()){
         eventLoop();
         window.clear(Color.BLACK);
         draw();
         window.display();
      }
   }

   protected void eventLoop(){
      for (Event event : window.pollEvents()) {
         if (event.type == Event.Type.CLOSED) {
            window.close();
         }
      }
   }

   protected void draw(){
      for (List<Sprite> sprites : map.getSpriteMap()) {
         for (Sprite sprite : sprites) {
            window.draw(sprite);
         }
      }
   }

}
