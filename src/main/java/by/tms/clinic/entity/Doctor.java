package by.tms.clinic.entity;

import by.tms.clinic.config.DocLevel;

public class Doctor {
    private String name;
    private DocLevel level;

    public Doctor(String name, DocLevel level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DocLevel getLevel() {
        return level;
    }

    public void setLevel(DocLevel level) {
        this.level = level;
    }
}
