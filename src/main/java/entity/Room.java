package entity;

import javax.swing.plaf.nimbus.State;
import java.util.Random;

enum RoomState {
    AVAILABLE, OCCUPIED, PRESERVED, LOCKED

}

enum TYPE {
    STANDARD, DOUBLE, TRIPE, FAMILY
}

public class Room {
    private String ID;
    private String number;
    private String type;
    private String floor;
    private String direction;
    private String description;
    private String status;
    private RoomState roomState = RoomState.LOCKED;


    //
    public void lockRoom() {
        setRoomState(RoomState.LOCKED);
        TYPE s = TYPE.valueOf("STANDARD");
        if (s == TYPE.STANDARD) {

        }
    }

    public RoomState getRoomState() {
        return roomState;
    }

    public void setRoomState(RoomState roomState) {
        this.roomState = roomState;
    }


    //PRIVATE MEMBER

    //GETTER AND SETTER


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
