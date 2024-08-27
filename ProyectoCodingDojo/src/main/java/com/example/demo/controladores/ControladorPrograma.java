package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.modelos.Programa;
import com.example.demo.modelos.Usuario;
import com.example.demo.servicios.ServicioPrograma;
import com.example.demo.servicios.ServicioUsuario;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorPrograma {
	@Autowired
	private final ServicioPrograma servicioPrograma;
	private final ServicioUsuario servicioUsuario;

	public ControladorPrograma(ServicioPrograma servicioPrograma, ServicioUsuario servicioUsuario) {
		this.servicioPrograma = servicioPrograma;
		this.servicioUsuario = servicioUsuario;
	}


	@GetMapping("/programas")
	public String desplegarPrograma(Model modelo,
								   HttpSession sesion) {
		if(sesion.getAttribute("id_usuario") == null) {
			return "redirect:/login";
		}

		List<Programa> programas = this.servicioPrograma.obtenerTodos();
		modelo.addAttribute("programas", programas);

		return "programas.jsp";
	}

	@GetMapping("/programas/nuevo")
	public String desplegarFormularioPrograma(@ModelAttribute("programa") Programa programa,
											HttpSession sesion) {
		if(sesion.getAttribute("id_usuario") == null) {
			return "redirect:/login";
		}
		return "formularioPrograma.jsp";
	}

	@PostMapping("/agregar/programa")
	public String procesarAgregarPrograma(@Valid @ModelAttribute("programa") Programa programa,
	                                    BindingResult validaciones,
	                                    HttpSession sesion, Model modelo) {
	    if (validaciones.hasErrors()) {
	        return "formularioPrograma.jsp";
	    }

	    Long idUsuario = (Long) sesion.getAttribute("id_usuario");
	    Usuario usuario = this.servicioUsuario.obtenerPorId(idUsuario);
	    programa.setUsuario(usuario);
	    servicioPrograma.insertarPrograma(programa);

	    return "redirect:/programas";
	} 
	

    @GetMapping("/programas/{id}")
    public String verDetallesPrograma(@PathVariable("id") Long id, Model model, HttpSession sesion) {
        Programa programa = servicioPrograma.obtenerPorId(id); // Obtener el programa por su ID
        if(sesion.getAttribute("id_usuario") == null) {
			return "redirect:/login";
		}
        model.addAttribute("programa", programa);

        return "detallePrograma.jsp";
    }

    @GetMapping("/editar/programa/{id}")
    public String desplegarEditarFormularioPrograma(@ModelAttribute("programa") Programa programa,
                                                    @PathVariable("id") Long id,
                                                    Model modelo,
                                                    HttpSession sesion) {
        if(sesion.getAttribute("id_usuario") == null) {
            return "redirect:/login";
        }
        programa = this.servicioPrograma.obtenerPorId(id);
        modelo.addAttribute("programa", programa);
        return "editarPrograma.jsp";
    }

    @PutMapping("/procesar/editar/programa/{id}")
    public String procesaEditarPrograma(@Valid @ModelAttribute("programa") Programa programa,
                                        BindingResult validaciones,
                                        @PathVariable("id") Long id,
                                        HttpSession sesion) {
        if(validaciones.hasErrors()) {
            return "editarPrograma.jsp";
        }
        Long idUsuario = (Long)sesion.getAttribute("id_usuario");
        Usuario usuario = this.servicioUsuario.obtenerPorId(idUsuario);
        programa.setId(id);
        programa.setUsuario(usuario);
        this.servicioPrograma.actualizarPrograma(programa);
        return "redirect:/programas";
    }
    
    @DeleteMapping("/eliminar/programa/{id}")
    public String eliminarPrograma(@PathVariable("id") Long id) {
        servicioPrograma.eliminarPorId(id);
        return "redirect:/programas";
    }

	@GetMapping("/logout")
	public String procesaLogout(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/login";
	}

}