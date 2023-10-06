package org.java.app.db.repo;

import java.util.List;
import org.java.app.db.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// * STEP 4 questa interfaccia gestisce l'accesso ai dati per l'entità Pizza cioè permette di eseguire operazioni di persistenza sulle entità Pizza senza dover scrivere manualmente il codice per le operazioni CRUD
@Repository
public interface PizzaRepo extends JpaRepository<Pizza, Integer> {
  // findByName perché il campo salvato nel db è name (se invece fosse stato title allora findByTitle)
  public List<Pizza> findByName(String pizzaName);
}
