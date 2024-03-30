package ru.gb.hw6.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank // аннотация для обозначения, что поле не долно быть пустым
    private String title;
    @NotBlank
    private String content;
    @CreationTimestamp
    private LocalDateTime creationDateTime;

}
