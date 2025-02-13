package fr.khj.gettingstarted.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class StudentEntity {
    private @Id
    @GeneratedValue Long id;
    private String name;
    private String role;

    public StudentEntity() {
    }

    public StudentEntity(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentEntity)) return false;

        return Objects.equals(id, ((StudentEntity) o).id) && Objects.equals(name, ((StudentEntity) o).name) && Objects.equals(role, ((StudentEntity) o).role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }
}
