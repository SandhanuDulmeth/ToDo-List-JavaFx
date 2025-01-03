package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ToDoListController implements Initializable {


    public Label lblDate;
    @FXML
    private VBox uncheckedTasks;

    @FXML
    private VBox checkedTasks;

    @FXML
    private TextField taskInput;

    @FXML
    private void handleAddTask() {
        String taskText = taskInput.getText().trim();
        if (!taskText.isEmpty()) {
            CheckBox newTask = new CheckBox(taskText);

            // Add a listener to handle moving tasks between containers
            newTask.selectedProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    uncheckedTasks.getChildren().remove(newTask);
                    checkedTasks.getChildren().add(newTask);
                } else {
                    checkedTasks.getChildren().remove(newTask);
                    uncheckedTasks.getChildren().add(newTask);
                }
            });

            // Add the new task to the unchecked container
            uncheckedTasks.getChildren().add(newTask);
            taskInput.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }
}
