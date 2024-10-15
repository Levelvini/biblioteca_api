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
public class Categoria {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros;
}
