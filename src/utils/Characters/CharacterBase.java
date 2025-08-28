package utils.Characters;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;
import utils.TextureUtils;

import static map.MapConstants.TEXTURE_SIZE;

public abstract class CharacterBase extends TextureUtils {
   protected Texture texture;
   protected Sprite sprite;

   public abstract void move(final Event event);

   public void update() {}

   public void draw(final RenderTarget window){
      window.draw(sprite);
   }

   protected final void init(final String textureName, final Vector2f startPosition) {
      texture = TextureUtils.TEXTURES.get(textureName);
      sprite = new Sprite();
      sprite.setTexture(texture);
      sprite.setScale(
         TEXTURE_SIZE / texture.getSize().x,
         TEXTURE_SIZE / texture.getSize().y
      );
      sprite.setPosition(startPosition.x * TEXTURE_SIZE, startPosition.y * TEXTURE_SIZE);
   }

   public Sprite getSprite() {
      return sprite;
   }
}
