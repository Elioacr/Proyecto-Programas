package com.example.demo.modelos;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String nombre;

    @NotNull
    @Size(min = 2, max = 50)
    private String correo;

    @NotNull
    @Size(min = 8)
    private String contraseña;

    @Column(updatable = false)
    private Date createdAt;

    private Date updatedAt;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Programa> programas;
    
    @Transient
	private String confirmarContraseña;

    public Usuario() {}

    public Usuario(Long id, String nombre, String correo, String contraseña, Date createdAt, Date updatedAt,
                   List<Programa> programas, String confirmarContraseña) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.programas = programas;
        this.confirmarContraseña = confirmarContraseña;
    }

    // Getters and Setters
    // ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }

	public String getConfirmarContraseña() {
		return confirmarContraseña;
	}

	public void setConfirmarContraseña(String confirmarContraseña) {
		this.confirmarContraseña = confirmarContraseña;
	}
}