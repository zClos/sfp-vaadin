package by.sfp.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class DomainCategory {
    private String id;
    private String name;
    private Set<ClassCategory> classCategories = new HashSet<>();

    public DomainCategory() {
    }

    public DomainCategory(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
