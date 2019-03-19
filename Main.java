/**
 * This is a program that takes the data from the Travel Experts database
 * and allows user to edit and view information through
 * a GUI. This is an assignment for class OOSD CMPP-264-Java
 *
 * @author: Eugenia Chiu
 * @version: 7.1
 * @since 2019-03-18
 *
 * */

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /*Override
    * This override will override any background process/methods and start with this one at runtime
    */
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Set parents stage and scene
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Assignment 7 ");
        primaryStage.setScene(new Scene(root, 600, 540));
        primaryStage.show(); //shows the scene
    }


    public static void main(String[] args) {
        launch(args); //launches program
    }
}
