package entity;

public class Bill {
    private String customerID;
    private String customerName;
    private String OrderID;
    private String ID;
    private String type;
    private String floor;
    private String dateBegin;
    private String dateEnd;
    private String roomNumber;

    public Bill() {
        this.customerID = null;
        this.customerName = null;
        this.OrderID = null;
        this.ID = null;
        this.type = null;
        this.floor = null;
        this.dateBegin = null;
        this.dateEnd = null;
        this.roomNumber = null;
    }


    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}
