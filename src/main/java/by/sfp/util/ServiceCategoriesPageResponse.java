package by.sfp.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ServiceCategoriesPageResponse {
    private Map<String, List<String>> fields;
    private List<String> common;
}
