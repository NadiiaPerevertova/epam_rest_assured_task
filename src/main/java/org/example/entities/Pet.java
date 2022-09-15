package org.example.entities;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Pet {
    private long id;
    private String name;
    private Category category;
    private String[] photoUrls;
    private Tag[] tags;
    private Status status;

    public enum Status {
        available, pending, sold
    }

    @Data
    @Accessors(chain = true)
    public static class Category {
        private long id;
        private String name;
    }

    @Data
    @Accessors(chain = true)
    public static class Tag {
        private long id;
        private String name;
    }
}
