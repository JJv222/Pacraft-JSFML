package map.base;

import logger.Logger;
import logger.LoggerLevel;
import map.DifficultyLevel;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import utils.TextureUtils;

import java.util.List;

import static logger.LoggerBase.MAP_CACHE_NOT_FOUND;

public abstract class MapBase {
   protected final Logger logger;
   private final static Float TEXTURE_SIZE = 50f;
   private final int height;
   private final int width;
   private final DifficultyLevel level;
   private final List<List<Character>> characterMap;

   protected final List<List<Sprite>> spriteMap;

   public MapBase(final int height, final int width, final DifficultyLevel level) {
      this.height = height;
      this.width = width;
      this.level = level;
      this.logger = new Logger(getClass());
      this.characterMap = initMap();
      spriteMap = createSpriteMap(height, width, level, characterMap);
   }

   protected abstract List<List<Character>> initMap();

   protected abstract List<List<Sprite>> createSpriteMap(int height, int width, DifficultyLevel level, List<List<Character>> characterMap);

   protected Sprite addSprite(final String texturePath, final Vector2f position) {
      Sprite sprite = new Sprite();
      Texture texture = TextureUtils.TEXTURES.get(texturePath);

      if (texture == null) {
         logger.log(LoggerLevel.ERROR, String.format(MAP_CACHE_NOT_FOUND, texturePath));
         throw new RuntimeException( String.format(MAP_CACHE_NOT_FOUND, texturePath));
      }

      sprite.setTexture(texture);
      sprite.setScale(
         TEXTURE_SIZE / texture.getSize().x,
         TEXTURE_SIZE / texture.getSize().y
      );
      sprite.setPosition(position.x * TEXTURE_SIZE, position.y * TEXTURE_SIZE);
      return sprite;
   }


   public List<List<Character>> getCharacterMap() {
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
