package com.levelvini.biblioteca.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String name;
    private int idade;

    @Setter(value = AccessLevel.NONE)
    @ManyToMany(mappedBy = "autors")
    private List<Livro> livros;
}
