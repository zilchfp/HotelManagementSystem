package entity;

public class CustomerReport {
    private String userID;
    private String IDNumber;
    private String customerName;
    private String roomID;
    private String dateBegin;
    private String dateEnd;

    public static class Builder {
        //Required
        private String userID;

        //Optional parameters
        private String IDNumber = "";
        private String customerName = "";
        private String roomID = "";
        private String dateBegin = "";
        private String dateEnd = "";

        public Builder(String userID) {
            this.userID = userID;
        }

        public Builder IDNumber(String val) {
            this.IDNumber = val;
            return this;
        }
        public Builder customerName(String val) {
            this.customerName = val;
            return this;
        }
        public Builder roomID(String val) {
            this.roomID = val;
            return this;
        }
        public Builder dateBegin(String val) {
            this.dateBegin = val;
            return this;
        }

        public Builder dateEnd(String val) {
            this.dateEnd = val;
            return this;
        }
        public CustomerReport build() {
            return new CustomerReport(this);
        }
    }

    private CustomerReport(Builder builder){
        userID = builder.userID;
        IDNumber = builder.IDNumber;
        customerName = builder.customerName;
        roomID = builder.roomID;
        dateBegin = builder.dateBegin;
        dateEnd = builder.dateEnd;
    }


    public String getUserID() {
        return userID;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRoomID() {
        return roomID;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}


