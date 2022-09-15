package org.example.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class StoreOrder {
    private long id;
    private long petId;
    private int quantity;
    private Date shipDate;
    private Status status;
    private boolean complete;

    public enum Status {
        placed, approved, delivered
    }
}
