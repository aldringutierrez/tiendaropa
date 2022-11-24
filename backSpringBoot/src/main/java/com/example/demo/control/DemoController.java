package com.example.demo.control;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Item;
import com.example.demo.dto.PedidoDto;
import com.example.demo.model.Persona;
import com.example.demo.repo.IPersonaRepo;

@RestController
public class DemoController {

	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name",required=false,defaultValue="World") String name,Model model) {
		
		Persona p = new Persona();
		p.setIdPersona(1);
		p.setNombre("aeg");
		repo.save(p);
		model.addAttribute("name",name);
		return "greeting";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("lista",repo.findAll());
		String qq = repo.findAll().toString();
		return qq;
	}
	

	@PostMapping("/guardarPedido")
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public void guardarPedido(@RequestBody PedidoDto pedidoDto) {

  	System.out.println("   *** Pedido Nombre : "+pedidoDto.getNombre());
  	System.out.println("   *** Pedido Tipo identificacion : "+pedidoDto.getTipide());
  	System.out.println("   *** Pedido Numero identificacion : "+pedidoDto.getNumide());
  	System.out.println("   *** Pedido Direccion : "+pedidoDto.getDireccion());
  	System.out.println("   *** Pedido fecha : "+pedidoDto.getFechora());
  	System.out.println("   *** Pedido items : "+pedidoDto.getItems().size());
    List<Item> items = new ArrayList<Item>();
    items = pedidoDto.getItems();
    for (Item item:items) {
    	System.out.println("   *** guardarPedido tipo : "+item.getTipo()+" cantidad : "+item.getCantidad());
    }
/*  	
      try {
          this.cuotaSocialService.guardarCuotaSocial(pedidoDto);
      } catch (Exception e) {
          ErrorOperacionDTO error = new ErrorOperacionDTO(-1, "No se pudo guardar cuota social. " + e.getMessage(),
                  e.getMessage());
          errores.add(error);
          respuesta.setErrores(errores);
      }
*/
  }    
	
	
	
	
}
