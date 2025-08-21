import map.DifficultyLevel;
import map.MapConstants;

public class Main {
   public static void main(String[] args) {

      final Game pacraft = new Game("Pacraft",
         MapConstants.FRAME_LIMIT,
         DifficultyLevel.EASY,
         MapConstants.MAP_HEIGHT,
         MapConstants.MAP_WIDTH
      );
      pacraft.run();
   }
}