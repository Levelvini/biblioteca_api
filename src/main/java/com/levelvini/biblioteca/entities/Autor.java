package com.levelvini.biblioteca.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private Integer age;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "autor")
    List<Livro> livroAutor;
}
