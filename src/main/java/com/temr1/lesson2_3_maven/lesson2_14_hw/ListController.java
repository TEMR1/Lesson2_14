package com.temr1.lesson2_3_maven.lesson2_14_hw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ListController {
    @FXML private HBox hBox1;
    @FXML private HBox hBox2;
    @FXML private HBox hBox3;

    @FXML private TextField textField;
    @FXML private Label label;

    private final ArrayList<String> list;
    private final ListModel model;
    private boolean isEditMode = false;
    private int editingIndex;


    public ListController() {
        this.model = new ListModel(this);
        this.list = new ArrayList<>();
    }

    //---------------------------------------GETTERS AND SETTERS-------------------------------------------------------
    public void setEditMode() {
        isEditMode = true;
    }


    //-----------------------------------------------ACTIONS------------------------------------------------------
    @FXML
    protected void onOkButtonClick(){
        if (textField.getText().isEmpty())
            return;

        if (isEditMode){
            isEditMode = false;
            list.set(editingIndex,textField.getText());
        }
        else {

            if (list.size() == 3){
                label.setText("Your list is full!");
                textField.clear();
                return;
            }

            list.add(textField.getText());
        }

        showElements();
        textField.clear();
    }

    @FXML
    protected void onEditButtonClick(ActionEvent event){
        Button button = (Button) event.getSource();
        HBox hBox = (HBox) button.getParent();
        String data = (String) button.getUserData();
        editingIndex = Integer.parseInt(data);

        model.edit(hBox, textField);
    }

    @FXML
    protected void onDeleteButtonClick(ActionEvent event){
        Button button = (Button) event.getSource();
        String data = (String) button.getUserData();
        int index = Integer.parseInt(data);

        list.remove(index);
        showElements();
    }

    protected void showElements(){
        if (!list.isEmpty()){
            model.addToList(list.get(0), hBox1);
        }
        else{
            model.removeFromList(hBox1);
        }


        if (list.size() > 1){
            model.addToList(list.get(1), hBox2);
        }
        else{
            model.removeFromList(hBox2);
        }


        if (list.size() > 2){
            model.addToList(list.get(2), hBox3);
        }
        else {
            model.removeFromList(hBox3);
        }
    }
}