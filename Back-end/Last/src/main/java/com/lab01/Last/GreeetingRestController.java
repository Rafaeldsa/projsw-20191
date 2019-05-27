package com.lab01.Last;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeetingRestController {
	@RequestMapping("/greetingRest")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
	    return new Greeting(name, saudacao());
	}
	
	@RequestMapping("/timeRest")
    public ServerTime serverTime() {
        return new ServerTime();
	} 
	
	public String saudacao() {
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
