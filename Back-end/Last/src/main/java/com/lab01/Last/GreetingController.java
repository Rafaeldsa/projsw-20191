package com.lab01.Last;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalTime;

@Controller
public class GreetingController {
	
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("greet", bomWhat());
        return "greeting";
    }
    
    @GetMapping("/time")
    public String time(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    	model.addAttribute("name", name);
    	model.addAttribute("time", ("" + LocalTime.now()).substring(0, ("" + LocalTime.now()).length()-4));
    	return "time";
    }
    
    public String bomWhat() {
    	String saudacao = "";
    	if(LocalTime.now().getHour() > 0 && LocalTime.now().getHour() < 12 ) {
    		saudacao += "Bom dia";
    	}
    	else if(LocalTime.now().getHour() > 12 && LocalTime.now().getHour() < 18 ) {
    		saudacao += "Boa tarde";
    	}
    	else {
    		saudacao += "Boa noite";
    	}
    	return saudacao;
    }
}