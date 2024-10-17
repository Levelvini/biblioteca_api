package com.levelvini.biblioteca.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long ID;
    public String name;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;
}
