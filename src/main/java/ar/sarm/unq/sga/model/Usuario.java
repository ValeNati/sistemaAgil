package ar.sarm.unq.sga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Usuario extends Persistible{
	
	private static final long serialVersionUID = 1L;
	

	private String nombre;
	@Transient
	@ManyToMany
	private List<Project>proyectos=new ArrayList<>();
	
	public Usuario(String nombre){
		this.nombre=nombre;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Project> getProyectos() {
		return proyectos;
	}

	public void setProjects(List<Project> proyectos) {
		this.proyectos = proyectos;
	}



}