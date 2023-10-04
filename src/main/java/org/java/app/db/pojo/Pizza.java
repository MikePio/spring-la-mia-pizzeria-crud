package org.java.app.db.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// * FASE 3 CREARE LA TABELLA
@Entity
public class Pizza {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // id della tabella
  private int id;

  // campi della tabella da inserire: nome descrizione foto prezzo
  @Column(length = 128, nullable = false, unique = true)
  private String name;
	private String description;
	private String photo;

  @Column(nullable = false, unique = false)
	private float price;
  
  // costruttore
  public Pizza() { }
	public Pizza(String name, String description, String photo, float price) {

		setId(id);
		setName(name);
		setDescription(description);
		setPhoto(photo);
		setPrice(price);
	}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

	public String getFormattedPrice() {
		return String.format("%.2f", price);
	}

  @Override
  public String toString() {
		return "Id: " + getId() + "\n" + "Name: " + getName() + "\n" + "Description: " + getDescription() + "\n" + "Image path: " + getPrice() + "\n" + "Price: " + getPrice() + "\n";
  }

}
