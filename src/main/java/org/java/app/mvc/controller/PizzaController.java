package org.java.app.mvc.controller;

import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// * STEP 7 - inizializzazione progetto - creare le rotte per mostrare nelle view i dati
// scrivere @Controller
// scrivere @Autowired private PizzaService pizzaService;
// creare le rotte index e show
// creare in templates i file index(pizza-index) e show(pizza-show)
@Controller
public class PizzaController {

  @Autowired
  private PizzaService pizzaService;

  // @GetMapping("/")
  @GetMapping
  public String getHome(Model model) {

    return "home";
    
    // List<Pizza> pizzas = pizzaService.findAll();
    // model.addAttribute("pizzas", pizzas);
    
    // * per far mostrare l'indice delle pizze anche quando l'url è "/"
    // return "pizza-index";
  }
  
  
  // ! STEP 3(FINALE) PER CERCARE UN OGGETTO TRAMITE FORM
  // AGGIUNGERE , @RequestParam(required = false) String pizzaName
  // AGGIUNGERE IN   @GetMapping("/pizzas") le successive 2 righe in basso ↓
  // List<Pizza> pizzas = pizzaName == null ? pizzaService.findAll() : pizzaService.findByName(pizzaName);                  
  // model.addAttribute("pizzas", pizzas);
  @GetMapping("/pizzas")
  public String getIndex(Model model, @RequestParam(required = false) String pizzaName) {   // * STEP 3(FINALE) parte 1 PER CERCARE UN OGGETTO TRAMITE FORM

    
    // senza ricerca
    // List<Pizza> pizzas = pizzaService.findAll();
    // model.addAttribute("pizzas", pizzas);

    // sintassi estesa
    // if(pizzaName == null){
      
    //   List<Pizza> pizzas = pizzaService.findAll();
    //   model.addAttribute("pizzas", pizzas);
    // }else{
      
    //   // * findByName perché il campo salvato nel db è name (se invece fosse stato title allora findByTitle)
    //   List<Pizza> pizzas = pizzaService.findByName(pizzaName);
    //   model.addAttribute("pizzas", pizzas);
    // }

      // * STEP 3(FINALE) parte 2 PER CERCARE UN OGGETTO TRAMITE FORM
      // sintassi con il ternario  
      List<Pizza> pizzas = pizzaName == null
                        ? pizzaService.findAll()
      // * findByName perché il campo salvato nel db è name (se invece fosse stato title allora findByTitle)
                        : pizzaService.findByName(pizzaName);
                        
      model.addAttribute("pizzas", pizzas);

    return "pizza-index";
  }

  @GetMapping("/pizzas/{id}")
  public String getShow(@PathVariable int id, Model model) {

    Pizza pizza = pizzaService.findById(id);
    model.addAttribute("pizza", pizza);

    return "pizza-show";
  }

  @GetMapping("/credits")
  public String credits(Model model){

    return "credits";
  }

  // * step 2 - Validazione errori - creare la rotta del create e la view(/file.html) 
  @GetMapping("/pizza-create")
  public String getCreateForm(){
    
    return "pizza-create";
  }
}
