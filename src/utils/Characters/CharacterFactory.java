package utils.Characters;

import org.jsfml.system.Vector2f;
import pacman.Pacman;

import java.util.ArrayList;
import java.util.List;

public class CharacterFactory {
    public static List<CharacterBase> createCharacters() {
        List<CharacterBase> characters = new ArrayList<>();

        characters.add(createPacman(new Vector2f(3, 3)));

        // Add ghosts
        // characters.add(createGhost(GhostType.BLINKY, new Vector2f(9, 9)));
        // characters.add(createGhost(GhostType.PINKY, new Vector2f(10, 9)));

        return characters;
    }

    private static Pacman createPacman(Vector2f position) {
        return new Pacman(position);
    }
}
