package com.example.keringo;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class HelloController {
    public Slider slSpeed;
    public Label lbSpeed;
    public Slider slRadius;
    public Label lbRadius;
    public Pane pane;
    public boolean aktiv = false;
    public Button gomb;

    private ImageView ivBall = new ImageView(new Image(getClass().getResourceAsStream("ball1.png")));

    public AnimationTimer timer;
    public int alfa = 0;
    public Circle kor = new Circle(300, 300, 200, Color.LIGHTGREEN);

    public void initialize() {
        pane.setClip(new Rectangle(600, 600));
        lbSpeed.textProperty().bind(Bindings.format("Speed: %.0f", slSpeed.valueProperty()));
        lbRadius.textProperty().bind(Bindings.format("Radius: %.0f", slRadius.valueProperty()));
        ivBall.setLayoutX(500-32);
        ivBall.setLayoutY(300-32);
        pane.getChildren().add(kor);
        pane.getChildren().add(ivBall);
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                mozgat();
            }
        };
    }

    public void mozgat() {
        int r = (int)slRadius.getValue();
        int x = 300 + (int)(r * Math.cos(alfa * Math.PI / 180));
        int y = 300 - (int)(r * Math.sin(alfa * Math.PI / 180));
        ivBall.setLayoutX(x-32);
        ivBall.setLayoutY(y-32);
        int speed = (int)slSpeed.getValue();
        alfa += speed;
        kor.setRadius(r);
    }

    public void onClickStart() {
        if (aktiv == false) {
            aktiv = true;
            timer.start();
            gomb.setText("Stop");
        } else {
            aktiv = false;
            timer.stop();
            gomb.setText("Start");
        }
    }

    public void onClickSzurke() {
        ivBall.setImage(new Image(getClass().getResourceAsStream("ball1.png")));
    }

    public void onClickMasik() {
        ivBall.setImage(new Image(getClass().getResourceAsStream("ball2.png")));
    }
}