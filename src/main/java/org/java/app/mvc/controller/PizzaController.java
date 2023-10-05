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

// * STEP 7 creare le rotte per mostrare nelle view i dati
// scrivere @Controller
// scrivere @Autowired private PizzaService pizzaService;
// creare le rotte index e show
// creare in templates i file index(pizza-index) e show(pizza-show)
@Controller
public class PizzaController {

  @Autowired
  private PizzaService pizzaService;

  @GetMapping("/")
  public String getHome(Model model) {

    return "home";
    
    // List<Pizza> pizzas = pizzaService.findAll();
    // model.addAttribute("pizzas", pizzas);
    
    // * per far mostrare l'indice delle pizze anche quando l'url è "/"
    // return "pizza-index";
  }

  @GetMapping("/pizzas")
  public String getIndex(Model model) {

    List<Pizza> pizzas = pizzaService.findAll();
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
}
