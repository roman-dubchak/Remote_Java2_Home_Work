package Lesson1_MainCircles;

import javax.swing.*;
import java.awt.*;

public class Background {
    private Color color;
    private float deltaTime;

    Background (){
        color = new Color (
                (int) ((deltaTime - deltaTime * Math.random()) * 255), //r
                (int) ((deltaTime - deltaTime * Math.random()) * 255), //g
                (int) ((deltaTime - deltaTime * Math.random()) * 255)  //b
        );
    }

    public void update(GameCanvas canvas, float deltaTime) {}
    public void render(GameCanvas canvas, Graphics g) {}
}