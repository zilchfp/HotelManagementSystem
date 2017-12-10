package entity;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class Manager {
    private String ID;
    private String username;
    private String password;
    private String name;
    private String gender;

    public void addRoom() {

    }
    public void deleteRoom() {

    }

    public void addReceptionist() {

        String sql = "\n" +
                "    insert into Receptionist values (\"10010\",\"HaHa\",\"Male\");";
    }
}
