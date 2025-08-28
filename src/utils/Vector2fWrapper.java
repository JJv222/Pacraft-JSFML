package utils;

import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

public final class Vector2fWrapper {
   public static final Vector2f ZERO = new Vector2f(0.0F, 0.0F);
   public float x;
   public float y;

   public static Vector2f add(final Vector2f var0, final Vector2f var1) {
      return Vector2f.add(var0, var1);
   }

   public static Vector2f sub(final Vector2f var0, final Vector2f var1) {
      return Vector2f.sub(var0, var1);
   }

   public static Vector2f componentwiseMul(final Vector2f var0, final Vector2f var1) {
      return Vector2f.componentwiseMul(var0, var1);
   }

   public static Vector2f componentwiseDiv(final Vector2f var0, final Vector2f var1) {
      return Vector2f.componentwiseDiv(var0, var1);
   }

   public static Vector2f mul(final Vector2f var0, float var1) {
      return Vector2f.mul(var0, var1);
   }

   public static Vector2f div(final Vector2f var0, float var1) {
      return Vector2f.div(var0, var1);
   }

   public static Vector2f neg(final Vector2f var0) {
      return Vector2f.neg(var0);
   }


   public Vector2fWrapper(float var1, float var2) {
      this.x = var1;
      this.y = var2;
   }

   public Vector2fWrapper(final Vector2i var1) {
      this((float) var1.x, (float) var1.y);
   }

   public Vector2fWrapper(final Vector2f var1) {
      this(var1.x, var1.y);
   }

   public Vector2f convert(){
      return new Vector2f(x,y);
   }

   @Override
   public boolean equals(final Object var1) {
      return var1 instanceof Vector2f && ((Vector2f) var1).x == this.x && ((Vector2f) var1).y == this.y;
   }

   @Override
   public int hashCode() {
      int var1 = x != 0.0F ? Float.floatToIntBits(x) : 0;
      int var2 = y != 0.0F ? Float.floatToIntBits(y) : 0;
      return var1 * 522133279 ^ var2;
   }

   @Override
   public String toString() {
      return "Vector2fWrapper{x=" + x + ", y=" + y + '}';
   }
}
