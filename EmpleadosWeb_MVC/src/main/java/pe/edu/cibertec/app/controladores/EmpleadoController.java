package pe.edu.cibertec.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.cibertec.app.repositorio.EmpleadoRepository;

@Controller
public class EmpleadoController {
	@Autowired
	private EmpleadoRepository empleadoRepo;
	
	@GetMapping("/inicio")
	public String index() {
		return "index";
	}
	
	@GetMapping("/buscar")
	public String buscar() {
		return "buscar";
	}
	
	@PostMapping("/buscar")
	public String buscar(Model modelo) {
		return "buscar";
	}
}
