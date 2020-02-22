package main.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Maks
 * 06.02.2020.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationSection extends Section {
    static final long serialVersionUID = 1L;

    public OrganizationSection() {
    }

    public List<Organization> getValues() {
        return values;
    }

    public void setValues(List<Organization> values) {
        this.values = values;
    }

    private List<Organization> values;

    public OrganizationSection(Organization... values) {
        this.values = new LinkedList<>(Arrays.asList(values));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return values != null ? values.equals(that.values) : that.values == null;
    }

    @Override
    public int hashCode() {
        return values != null ? values.hashCode() : 0;
    }
}
