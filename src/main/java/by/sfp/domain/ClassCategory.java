package by.sfp.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "domainCategory")
public class ClassCategory implements Comparable<ClassCategory> {
    private String id;
    private String name;
    private DomainCategory domainCategory;

    public ClassCategory() {
    }

    public ClassCategory(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name+id;
    }

    @Override
    public int compareTo(ClassCategory o) {
        return id.compareTo(o.id);
    }
}
