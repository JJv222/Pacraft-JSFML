import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

public class Main {

    public static void main(String[] args) {

        //Create the window
        RenderWindow window = new RenderWindow();
        window.create(new VideoMode(640, 480), "Hello JSFML!");
        window.setFramerateLimit(30);

        while (window.isOpen()) {
            //Fill the window with red
            window.clear(Color.RED);

            //Display what was drawn (... the red color!)
            window.display();

            //Handle events
            for (Event event : window.pollEvents()) {
                if (event.type == Event.Type.CLOSED) {
                    //The user pressed the close button
                    window.close();
                }
            }
        }
    }
}