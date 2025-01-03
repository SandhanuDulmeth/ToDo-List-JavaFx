package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ToDoListController {

    @FXML
    private VBox taskContainer;

    @FXML
    private TextField taskInput;

    @FXML
    private Button addButton;

    @FXML
    private void handleAddTask() {
        String taskText = taskInput.getText().trim();
        if (!taskText.isEmpty()) {
            CheckBox newTask = new CheckBox(taskText);
            taskContainer.getChildren().add(newTask);
            taskInput.clear();
        }
    }
}
