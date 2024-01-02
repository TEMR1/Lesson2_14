package com.temr1.lesson2_3_maven.lesson2_14_hw;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ListModel {
    private ListController listController;

    ListModel(ListController controller){
        this.listController = controller;
    }

    public void addToList(String str, HBox hBox){
        ObservableList<Node> nodeList = hBox.getChildren();

        for (Node node : nodeList) {
            if (node instanceof Label label){
                label.setText(str);
                hBox.setVisible(true);
                break;
            }
        }
    }

    public void edit(HBox hBox, TextField textField){
        ObservableList<Node> nodeList = hBox.getChildren();

        for (Node node : nodeList) {
            if (node instanceof Label label){
                listController.setEditMode();
                textField.setText(label.getText());
            }
        }
    }

    public void removeFromList(HBox hBox){
        hBox.setVisible(false);
    }
}
