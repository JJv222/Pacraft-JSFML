package pacman;

import logger.LoggerUtils;
import map.MapConstants;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;
import utils.Characters.CharacterBase;
import utils.Vector2fWrapper;

import java.util.logging.Logger;

import static map.MapConstants.TEXTURE_SIZE;

public final class Pacman extends CharacterBase {
   private static final String TEXTURE_NAME = "steve.jpg";
   private static final Logger logger = LoggerUtils.getLogger(Pacman.class);
   private static final float MOVE_SPEED = TEXTURE_SIZE/3f;
   private Keyboard.Key moveDirection;

   public Pacman(Vector2f startPosition) {
      logger.info(String.format(LoggerUtils.CHARACTER_INIT, TEXTURE_NAME));
      init(TEXTURE_NAME, startPosition);
      logger.info(String.format(LoggerUtils.CHARACTER_POSITION_UPDATE,
         startPosition.x, startPosition.y));
   }

   @Override
   public void move(final Event event) {
      if (event.type == Event.Type.KEY_PRESSED) {
         Keyboard.Key newDirection = event.asKeyEvent().key;
         if (newDirection == Keyboard.Key.LEFT || newDirection == Keyboard.Key.RIGHT ||
             newDirection == Keyboard.Key.UP || newDirection == Keyboard.Key.DOWN) {
            moveDirection = newDirection;
         }
      }
   }

   public void update() {
      if (moveDirection != null) {
         Vector2f currentPos = sprite.getPosition();
         Vector2fWrapper newPos = new Vector2fWrapper(currentPos);

         switch (moveDirection) {
            case LEFT -> newPos.x -= MOVE_SPEED;
            case RIGHT -> newPos.x += MOVE_SPEED;
            case UP -> newPos.y -= MOVE_SPEED;
            case DOWN -> newPos.y += MOVE_SPEED;
         }

         // Screen limit
         if (newPos.x < 0) newPos.x = MapConstants.WINDOW_WIDTH - TEXTURE_SIZE;
         if (newPos.x >= MapConstants.WINDOW_WIDTH) newPos.x = 0;
         if (newPos.y < 0) newPos.y = MapConstants.WINDOW_HIGH - TEXTURE_SIZE;
         if (newPos.y >= MapConstants.WINDOW_HIGH) newPos.y = 0;

         if (!currentPos.equals(newPos)) {
            sprite.setPosition(newPos.convert());
            logger.info(String.format(LoggerUtils.CHARACTER_POSITION_UPDATE,
               newPos.x / TEXTURE_SIZE, newPos.y / TEXTURE_SIZE));
         }
      }
   }
}
