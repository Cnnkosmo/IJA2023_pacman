import javax.swing.*;
import java.awt.Canvas

public class Game extends Canvas implements  Runnable{


    public static final int WIDTH = 640, HEIGHT = 480;
    public static final String TITLE = "Pac_Man";

    private Thread thread;
    public Game()
    {

    }

    public synchronized void start()
    {

    }

    public synchronized void stop()
    {
        
    }

    private void tick()
    {

    }

    private void render()
    {

    }



    public static void main(String[] args)
    {
        Game game = new Game();
        JFrame frame = new JFrame();
        frame.setTitle(Game.TITLE);
        frame.add(game);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        game.start();
    }

    @Override
    public void run()
    {

    }
}
