package main.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Maks
 * 06.02.2020.
 */
public class OrganizationSection extends Section {
    static final long serialVersionUID = 1L;

    private List<Organization> values;

    public OrganizationSection(Organization... values) {
        this.values = new LinkedList<>(Arrays.asList(values));
    }
}
