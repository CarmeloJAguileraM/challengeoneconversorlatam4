
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConversionController {

	@Controller
	public class ConversorController {
	    
	    @GetMapping("/convertirMoneda")
	    public String convertirMoneda(Model model) {
	        // lógica para convertir la moneda
	        return "resultadoMoneda";
	    }
	    
	}

	private static final Object resultado = null;


    @PostMapping("/convertirDivisa")
    public String convertirDivisa(@RequestParam String cantidad, @RequestParam String divisaOrigen,
                                  @RequestParam String divisaDestino, Model model) {

        // Aquí va el código para la conversión de divisas

        model.addAttribute("resultado", resultado);
        return "resultado";
    }

    @PostMapping("/convertirTemperatura")
    public String convertirTemperatura(@RequestParam String cantidad, @RequestParam String temperaturaOrigen,
                                       @RequestParam String temperaturaDestino, Model model) {

        // Aquí va el código para la conversión de temperaturas

        model.addAttribute("resultado", resultado);
        return "resultado";
    }
    
    
}
