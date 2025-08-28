package logger;

import java.util.logging.Logger;

public interface LoggerUtils {
    // Map related messages
    String MAP_CACHE_NOT_FOUND = "Texture %s not found in the cache !";
    String MAP_INIT_START = "Initializing map..";
    String MAP_INIT_END = "Map Initialized successfully!";

    // Game related messages
    String GAME_START = "Game is starting...";
    String GAME_CLOSE = "Game is closing...";
    String GAME_INIT = "Initializing game with title: %s";

    // Texture related messages
    String TEXTURE_LOADING_START = "Starting texture loading process";
    String TEXTURE_LOADING_ERROR = "Error loading texture: %s";
    String TEXTURE_LOADING_SUCCESS = "Successfully loaded texture: %s";
    String TEXTURE_LOADING_COMPLETE = "All textures loaded successfully";

    // Character related messages
    String CHARACTER_INIT = "Initializing character with texture: %s";
    String CHARACTER_POSITION_UPDATE = "Character position updated to: x=%f, y=%f";

    static Logger getLogger(final Class<?> clazz) {
        return Logger.getLogger(clazz.getSimpleName());
    }
}
