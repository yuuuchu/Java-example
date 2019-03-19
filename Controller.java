/**
 * This class is the controller for the program. This controller contains the SQL statement and logic to handle the code.
 * It also contains the label and text outputs to the GUI.
 * This is an assignment for class OOSD CMPP-264-Java
 * note: This assignment does not require error checking, HOWEVER!! error checking should ALWAYS be put in. DO NOT develop and
 * release code that does not have error checking at every level.
 *
 * @author: Eugenia Chiu
 * @version: 7.1
 * @since 2019-03-18
 *
 * */

package sample;


import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

//public class can be initialized. Used to load combo box. Initialized is important because javaFX needs to have an object that
//is made at the beginning in order to load the GUI.
public class Controller implements Initializable {

    //Open connection to database
    Connection conn;

    //All the variables need @FXML in the front so that javafx can see and call the object
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox <Agent> cbAgentId;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtAgentId;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtMiddleInitial;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtAgencyId;


    /*This is the fill method for the combo box. It connects to the SQL database and will select everything from the database.
    *It does not return anything hence is it void and it does not take in any parameters.
    * This method simply retrieves data and inserts it into an Observable list of Agents objects.
    * So basically, this method makes a list of Agents
    * */
    private void fillCombo() throws SQLException{
        ObservableList<Agent> agent = FXCollections.observableArrayList();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from agents");
        while (rs.next()){
            agent.add(new Agent(rs.getInt("AgentId"), rs.getString("AgtFirstName"),
                    rs.getString(3), rs.getString("AgtLastName"), rs.getString("AgtBusPhone"),
                    rs.getString("AgtEmail"), rs.getString("AgtPosition"), rs.getInt("AgencyId")));
        }
        cbAgentId.setItems(agent);
    }

    /*
    * This method is the fill Label method that fills in all the form fields on the GUI.
    * It does not take any parameters and does not have a return value. THis method basically takes all the information from
    * the combo fill (list of agents) and displays the information accordingly in the correct fields on the GUI.
    *
    * Now, it is important to note that the Agent ID is being stored in the combo box and that is how this method sees the correct
    * ID information. The cdAgentId.getValue().getAgentId() is getting the value from the Agent object that is stored in combobox list
    * that was made by fillcombo method.
    *
    * If you do NOT want to do it this way, you can retrieve the value (Agent ID) from the combobox, handle it in some way and pass it
    * through as a parameter to this method. At the end of the day, this method REQUIRES some sort of value identifier to display
    * the correct agent information.
    * */
    private void fillLabel() throws SQLException {
        if (!cbAgentId.getSelectionModel().isEmpty()) {
            txtAgentId.setText(cbAgentId.getValue().getAgentId() + " ");
            txtFirstName.setText(cbAgentId.getValue().getAgtFirstName() + "");
            // txtMiddleInitial.setText(cbAgentId.getValue().getAgtMiddle());
            txtLastName.setText(cbAgentId.getValue().getAgtLastName() + "");
            txtPhone.setText(cbAgentId.getValue().getAgtBusPhone() + "");
            txtEmail.setText(cbAgentId.getValue().getAgtEmail() + "");
            txtPosition.setText(cbAgentId.getValue().getAgtPosition() + "");
            txtAgencyId.setText(cbAgentId.getValue().getAgencyId() + "");
        }
    }

    /*
    * This is the update method. Once again, it does not return anything and takes in no parameters
    * and does not return any value. This update function is used to update the database based on the change that user has made in the
    * GUI. Instead of a create statement, I have chosen to use a prepared statement.
    *
    * The prepared statement prevents SQL injection because the values need to be retrieved from the Agent class. Cannot put in values
    * directly into database through this method. This also saves me from parsing everything to a toString.
    * for the fillCombo method, I have chosen to use the create statement for example purposes.
    * */
    private void update() throws SQLException{
            //Sql prepared statement set up
            PreparedStatement stmt = conn.prepareStatement("update agents set AgentId =? , AgtFirstName = ?, AgtMiddleInitial = ?, AgtLastName = ?, AgtBusPhone = ?, " +
                    "AgtEmail = ?, AgtPosition = ?, AgencyId = ? where AgentId = ?");

            //getting the values from the txtboxes
            stmt.setString(1, txtAgentId.getText());
            stmt.setString(2, txtFirstName.getText());
            stmt.setString(3, txtMiddleInitial.getText());
            stmt.setString(4, txtLastName.getText());
            stmt.setString(5, txtPhone.getText());
            stmt.setString(6, txtEmail.getText());
            stmt.setString(7, txtPosition.getText());
            stmt.setString(8, txtAgencyId.getText());
            stmt.setString(9, txtAgentId.getText());

            //update the information to database
            stmt.executeUpdate();
            fillCombo();
    }

    /*
    * This is the action listener to fill the label when combo changes
    * */
    @FXML
    void changeListener(ActionEvent event) {

        try{
            fillLabel();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    /*Event handler for the edit button. When edit button is clicked, enable the text fields for edit purposes*/
    @FXML
    void edit(ActionEvent event) {
       txtFirstName.setDisable(false);
       txtLastName.setDisable(false);
       txtPhone.setDisable(false);
       txtEmail.setDisable(false);
       txtPosition.setDisable(false);
       txtAgencyId.setDisable(false);
       btnSave.setDisable(false);
       btnEdit.setDisable(true);
    }

    /*This is the save action even handler. It calls the update method
    * to update to database
    * and also disables the text fields*/
    @FXML
    void save(ActionEvent event) throws SQLException{
        update();
        btnSave.setDisable(true);
        btnEdit.setDisable(false);
        txtFirstName.setDisable(true);
        txtLastName.setDisable(true);
        txtPhone.setDisable(true);
        txtEmail.setDisable(true);
        txtPosition.setDisable(true);
        txtAgencyId.setDisable(true);
        cbAgentId.getSelectionModel().select(0);

    }

    /*
    * This is the initialize method that initializes all the objects and set it up at runtime.
    * It will connect to the databse and fill the combo box. It will auto select the first data entry and then it will
    * fill all the labels and text fields with the first agent data.
    * */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            conn = new DBConnection().getConnection();
            fillCombo();
            cbAgentId.getSelectionModel().selectFirst();
            fillLabel();


        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}
