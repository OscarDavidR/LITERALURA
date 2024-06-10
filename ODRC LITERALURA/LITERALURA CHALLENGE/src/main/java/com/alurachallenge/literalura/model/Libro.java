package com.alurachallenge.literalura.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(
            name = "libro_autores",
            joinColumns = @JoinColumn(name = "libro_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id",referencedColumnName = "id")
    )
    private List<Autor> autores;
    private List<String> lenguajes;
    private Double numeroDeDescargas;

    public Libro (){}

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.lenguajes = datosLibro.idiomas();
        this.numeroDeDescargas = datosLibro.numeroDeDescargas();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<String> lenguajes) {
        this.lenguajes = lenguajes;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("************************************\n");
        sb.append("\t****Libro****\n");
        sb.append("titulo: ").append(titulo).append("\n");
        sb.append("autores: ");
        if (!autores.isEmpty()) {
            for (int i = 0; i < autores.size() - 1; i++) {
                sb.append(autores.get(i).getNombre()).append(", ");
            }
            sb.append(autores.get(autores.size() - 1).getNombre());
        }
        sb.append("\n");
        sb.append("lenguajes: ");
        if (!lenguajes.isEmpty()) {
            for (int i = 0; i < lenguajes.size() - 1; i++) {
                sb.append(lenguajes.get(i)).append(", ");
            }
            sb.append(lenguajes.get(lenguajes.size() - 1));
        }
        sb.append("\n");
        sb.append("numeroDeDescargas: ").append(numeroDeDescargas).append("\n");
        sb.append("************************************\n");
        return sb.toString();
    }
}
