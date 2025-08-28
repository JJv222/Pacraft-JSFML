import logger.LoggerUtils;
import map.DifficultyLevel;
import map.GameMap;
import map.MapConstants;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;
import utils.Characters.CharacterBase;
import utils.Characters.CharacterFactory;

import java.util.List;
import java.util.logging.Logger;

public final class Game {
   private final RenderWindow window;
   private final int frameLimit;
   private final DifficultyLevel level;
   private final GameMap map;
   private final List<CharacterBase> characters;
   private final String title;
   private int score;
   private static final Logger logger = LoggerUtils.getLogger(Game.class);

   public Game(String title, int frameLimit, DifficultyLevel level, int height, int weight) {
      this.title = title;
      logger.info(String.format(LoggerUtils.GAME_INIT, title));
      this.window = new RenderWindow();
      window.create(new VideoMode(MapConstants.WINDOW_WIDTH, MapConstants.WINDOW_HIGH), title);
      this.frameLimit = frameLimit;
      this.level = level;
      this.map = new GameMap(height, weight, level);
      this.characters = CharacterFactory.createCharacters();
   }

   void run(){
      logger.info(LoggerUtils.GAME_START);
      window.setFramerateLimit(frameLimit);
      window.setTitle(title);

      while(window.isOpen()){
         window.clear(Color.BLACK);
         eventLoop();
         update();
         draw();
         window.display();
      }
   }

   private void eventLoop(){
      for (Event event : window.pollEvents()) {
         if (event.type == Event.Type.CLOSED) {
            logger.info(LoggerUtils.GAME_CLOSE);
            window.close();
         }
         characters.forEach(element->element.move(event));
      }
   }

   private void draw(){
      for (List<Sprite> sprites : map.getSpriteMap()) {
         for (Sprite sprite : sprites) {
            window.draw(sprite);
         }
      }
      characters.forEach(element->element.draw(window));
   }

   private void update(){
      characters.forEach(CharacterBase::update);
   }

}
