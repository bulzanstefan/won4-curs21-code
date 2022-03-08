package ro.fasttrackit.curs21.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Approval {
    @Id
    @GeneratedValue
    private int id;
    private String approver;
    private String message;

    public Approval() {
    }

    public Approval(String approver, String message) {
        this.approver = approver;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getApprover() {
        return approver;
    }

    public String getMessage() {
        return message;
    }
}
