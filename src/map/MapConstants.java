package map;

import org.jsfml.system.Vector2f;

public interface MapConstants {
   int FRAME_LIMIT = 60;
   int MAP_WIDTH = 21;
   int MAP_HEIGHT = 21;
   int MAP_SCALE = 50; //px
   int WINDOW_WIDTH = MAP_WIDTH * MAP_SCALE;
   int WINDOW_HIGH = MAP_HEIGHT * MAP_SCALE;


   Vector2f PACMAN_START_POS = new Vector2f(3, 3);
}
