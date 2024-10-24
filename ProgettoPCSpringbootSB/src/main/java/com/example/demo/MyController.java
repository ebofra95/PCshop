package com.example.demo;

import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
@Controller
public class MyController {
	ArrayList <Carrello> listapcselezionati = new ArrayList<>();
	ArrayList <Pc> listapc = new ArrayList<>();
	double somma = 0;
	public void fillUp() {
		listapc.removeAll(listapc);
		listapc.add(new Pc("iMac", "Apple","M3 2TB" , 2000 , "https://www.tradeinn.com/f/13782/137821822_3/apple-imac-retina-4k-21.5-i5-3.0ghz-8gb-256gb-ssd.webp" ));
		listapc.add(new Pc("HP", "Windows", "i7 1TB", 700 , "https://www.iltelefoninoshop.com/wp-content/uploads/2023/09/PC-HP-250-G7-15.6-4256GB-Wi-Fi-7DB75EA-Argento-Cenere-Scuro-1-1-1.jpg"));
		listapc.add(new Pc("Dell", "Windows", "i5 512GB", 600 , "https://lds.com.np/wp-content/uploads/2024/05/Dell-Latitude-3440-5-scaled.jpg"));
		
	}
@GetMapping("/")
public String getIndex(Model m1) {
	fillUp();
	m1.addAttribute("listapc", listapc);
	listapcselezionati.removeAll(listapcselezionati);
	return "index";
	
	

}

@PostMapping("/process")
public String getCarrello(@RequestParam("nome") ArrayList<String> nomi,
		@RequestParam("num") ArrayList<Integer> numeri,Model m1) {
		
	
	listapcselezionati.removeAll(listapcselezionati);
	for (int i = 0; i < nomi.size(); i++) {

		String str = "Hai selezionato: ";
		String str1 = "Al costo di: ";

		if (numeri.get(i) != 0) {

			str += nomi.get(i) + " " + numeri.get(i) + " volte\n";
			somma += numeri.get(i) * listapc.get(i).getPrezzo();
			str1 += somma + "€";
			listapcselezionati.add(new Carrello(listapc.get(i).nome, listapc.get(i).marca, listapc.get(i).descrizione, listapc.get(i).prezzo, listapc.get(i).url,numeri.get(i)));
		}

	}
	System.out.println("La somma degli prezzi è: " + somma + " euro");

	m1.addAttribute("somma", somma);
	m1.addAttribute("lista", listapcselezionati);
	return ("carrello");

}
@GetMapping("/carrello")
public String printCarrello(Model m1){
	m1.addAttribute("somma", somma);
	m1.addAttribute("lista", listapcselezionati);
	return ("carrello");
}
}