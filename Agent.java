/**
 * This class makes the agent object that is used in the controller class.
 * This is an assignment for class OOSD CMPP-264-Java
 *
 * @author: Eugenia Chiu
 * @version: 7.1
 * @since 2019-03-18
 *
 * */

package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

//Agent class is public so that it can be reused
public class Agent {

    //setting all variables to private
    private SimpleIntegerProperty agentId;
    private SimpleStringProperty agtFirstName;
    private SimpleStringProperty agtMiddle;
    private SimpleStringProperty agtLastName;
    private SimpleStringProperty agtBusPhone;
    private SimpleStringProperty agtEmail;
    private SimpleStringProperty agtPosition;
    private SimpleIntegerProperty agencyId;

    //provide an empty constructor
    public Agent(){}

    /*
    * Constructor with three parameters
    * @param int agtId, String agtFirstName, String agtLastName
    * */
    public Agent(int agtId, String agtFirstName, String agtLastName){
        this.agentId = new SimpleIntegerProperty(agtId);
        this.agtFirstName = new SimpleStringProperty(agtFirstName);
        this.agtLastName = new SimpleStringProperty(agtLastName);
    }

    /* Constructor for full Agent object
    * @param int agtId, String agtFirstName, String agtMiddle, String agtLastName, String agtBusPhone, String agtEmail
    * @param String agtPosition, int agentId
    * */
    public Agent(int agtId, String agtFirstName, String agtMiddle, String agtLastName,
                 String agtBusPhone, String agtEmail, String agtPosition, int agencyId){
        super();
        this.agentId = new SimpleIntegerProperty(agtId);
        this.agtFirstName = new SimpleStringProperty(agtFirstName);
        this.agtMiddle = new SimpleStringProperty(agtMiddle);
        this.agtLastName = new SimpleStringProperty(agtLastName);
        this.agtBusPhone = new SimpleStringProperty(agtBusPhone);
        this.agtEmail = new SimpleStringProperty(agtEmail);
        this.agtPosition = new SimpleStringProperty(agtPosition);
        this.agencyId = new SimpleIntegerProperty(agencyId);

    }

    //Getter and setters for the private variables
    public int getAgentId() {
        return agentId.get();
    }

    public void setAgentId(int agentId) {
        this.agentId.set(agentId);
    }

    public String getAgtFirstName() {
        return agtFirstName.get();
    }

    public void setAgtFirstName(String agtFirstName) {
        this.agtFirstName.set(agtFirstName);
    }

    public String getAgtMiddle() {
        if(agtMiddle == null){
            return " ";
        }
        return agtMiddle.get();
    }


    public void setAgtMiddle(String agtMiddle) {
        this.agtMiddle.set(agtMiddle);
    }

    public String getAgtLastName() {
        return agtLastName.get();
    }


    public void setAgtLastName(String agtLastName) {
        this.agtLastName.set(agtLastName);
    }

    public String getAgtBusPhone() {
        return agtBusPhone.get();
    }


    public void setAgtBusPhone(String agtBusPhone) {
        this.agtBusPhone.set(agtBusPhone);
    }

    public String getAgtEmail() {
        return agtEmail.get();
    }


    public void setAgtEmail(String agtEmail) {
        this.agtEmail.set(agtEmail);
    }

    public String getAgtPosition() {
        return agtPosition.get();
    }


    public void setAgtPosition(String agtPosition) {
        this.agtPosition.set(agtPosition);
    }

    public int getAgencyId() {
        return agencyId.get();
    }

    public void setAgencyId(int agencyId) {
        this.agencyId.set(agencyId);
    }

    //toString override method. This is used for the combo box printout
    @Override
    public String toString(){
    return agentId.get() + " ";

    }
}
