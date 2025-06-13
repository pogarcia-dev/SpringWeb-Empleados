package pe.edu.cibertec.app.modelos;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(/*name = "Nombre", */length = 255, nullable = false)
	private String nombre;
	
	@Column(name = "Apellido", length = 255, nullable = false)
	private String apellidos;
	
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal salario;
	
	@ManyToOne
	@JoinColumn(name = "DepartamentoID", nullable = false)
	private Departamento departamento;
	
	public Empleado() {}

	public Empleado(int id, String nombre, String apellidos, BigDecimal salario, Departamento departamento) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
		this.departamento = departamento;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", salario=" + salario
				+ ", departamento=" + departamento + "]";
	}
}
