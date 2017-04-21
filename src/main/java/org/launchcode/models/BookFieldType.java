package org.launchcode.models;

/**
 * Created by LaunchCode
 */
public enum BookFieldType {

    ISBN("Employer"),
    LOCATION ("Quantity"),
    CORE_COMPETENCY ("Skill"),
    POSITION_TYPE ("Position Type"),
    ALL ("All");

    private final String name;

    BookFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
