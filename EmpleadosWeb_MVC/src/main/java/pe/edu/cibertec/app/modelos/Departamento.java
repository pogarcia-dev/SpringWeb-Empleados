package pe.edu.cibertec.app.modelos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
//@Table(name = "Departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(/*name = "Nombre", */length = 200, nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private List<Empleado> empleados;
	
	public Departamento() {}

	public Departamento(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		empleados = new ArrayList<>();
	}

	public Departamento(int id, String nombre, List<Empleado> empleados) {
		this.id = id;
		this.nombre = nombre;
		this.empleados = empleados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", empleados=" + empleados + "]";
	}
}
