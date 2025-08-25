package map.base;

import map.DifficultyLevel;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import utils.TextureUtils;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logger.LoggerConfig;

import static logger.LoggerConfig.getLogger;
import static map.MapConstants.TEXTURE_SIZE;

public abstract class MapBase {
   protected final Logger logger;
   private final int height;
   private final int width;
   private final DifficultyLevel level;
   private final Character[][]characterMap;

   protected final List<List<Sprite>> spriteMap;

   public MapBase(final int height, final int width, final DifficultyLevel level) {
      this.height = height;
      this.width = width;
      this.level = level;
      this.logger = getLogger(MapBase.class);
      this.characterMap = initMap();
      spriteMap = createSpriteMap(height, width, level, characterMap);
   }

   protected abstract Character[][] initMap();

   protected abstract List<List<Sprite>> createSpriteMap(int height, int width, DifficultyLevel level, Character[][] characterMap);

   protected Sprite addSprite(final String texturePath, final Vector2f position) {
      Sprite sprite = new Sprite();
      Texture texture = TextureUtils.TEXTURES.get(texturePath);

      if (texture == null) {
         logger.log(Level.SEVERE, String.format(LoggerConfig.MAP_CACHE_NOT_FOUND, texturePath));
         throw new RuntimeException(String.format(LoggerConfig.MAP_CACHE_NOT_FOUND, texturePath));
      }

      sprite.setTexture(texture);
      sprite.setScale(
         TEXTURE_SIZE / texture.getSize().x,
         TEXTURE_SIZE / texture.getSize().y
      );
      sprite.setPosition(position.x * TEXTURE_SIZE, position.y * TEXTURE_SIZE);
      return sprite;
   }


   public Character[][] getCharacterMap() {
      return characterMap;
   }

   public int getHeight() {
      return height;
   }

   public int getWidth() {
      return width;
   }

   public DifficultyLevel getLevel() {
      return level;
   }

   public List<List<Sprite>> getSpriteMap() {
      return spriteMap;
   }
}
