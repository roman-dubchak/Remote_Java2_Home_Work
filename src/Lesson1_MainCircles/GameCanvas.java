package Lesson1_MainCircles;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel{
    private long lastFrameTime;
    private MainCircles controller; // содержит ссылку на MainCircles
//    private Color color;
//    private Background background;
Background background = new Background();


    GameCanvas(MainCircles controller) {
        this.controller = controller;
        lastFrameTime = System.nanoTime();
        Color color = new Color(background.setColor(lastFrameTime));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = currentTime;

        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        controller.getBackground();

        repaint();
    }


    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }
}
