package com.example.keringo;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class HelloController {
    public Slider slSpeed;
    public Label lbSpeed;
    public Slider slRadius;
    public Label lbRadius;

    public void initialize() {
        lbSpeed.textProperty().bind(Bindings.format("Speed: %.0f", slSpeed.valueProperty()));
        lbRadius.textProperty().bind(Bindings.format("Radius: %.0f", slRadius.valueProperty()));
    }

    public void onClickStart() {
    }
}