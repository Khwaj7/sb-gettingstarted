package fr.khj.gettingstarted.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    private @Id @GeneratedValue Long id;
    @NotBlank
    private String title;
    private String description;
}
