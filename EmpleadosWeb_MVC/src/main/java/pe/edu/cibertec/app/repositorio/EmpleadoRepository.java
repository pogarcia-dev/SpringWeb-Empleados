package pe.edu.cibertec.app.repositorio;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pe.edu.cibertec.app.modelos.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	// Create (usando SQL)
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO Empleado (Nombre, Apellido, Salario, DepartamentoID) VALUES (:nombreP, :apellidoP, :salarioP, :departamentoIdP)", nativeQuery = true)
	void registrar(@Param("nombreP") String nombre, @Param("apellidoP") String apellido, @Param("salarioP") BigDecimal salario, @Param("departamentoIdP") Integer departamentoId);
	
	// Read (usando JPQL)
	@Query("SELECT e FROM Empleado e WHERE e.id = :idP")
	Empleado buscarPorId(@Param("idP") Integer id);
	
	// Update (usando JPQL)
	@Transactional
	@Modifying
	@Query("UPDATE Empleado e SET e.Nombre = :nombreP, e.Apellido = :apellidoP, e.Salario = :salarioP, e.DepartamentoID = :depaIdP WHERE e.ID = :idP")
	void actualizar(@Param("idP") Integer id, @Param("nombreP") String nombre, @Param("apellidoP") String apellido, @Param("salarioP") BigDecimal salario, @Param("depaIdP") Integer departamentoId);
	
	// Delete (usando JPQL)
	@Transactional
	@Modifying
	@Query("DELETE FROM Empleado e WHERE e.ID = :idP")
	void eliminar(@Param("idP") Integer id);
	
	// Adicional: buscar por departamento (usando JPQL)
	@Query("SELECT e FROM Empleado e WHERE e.departamento.id = :depaIdP")
	List<Empleado> buscarPorDepartamento(@Param("depaIdP") Integer departamentoId);
}
