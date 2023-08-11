package Model;

public class Product {
	
private int id;
private String category;
private String name;
private double  price;
private String image;
private String description;
private String brand;


public String getBrand() {
	return brand;
}


public int getId() {
	return id;
}

public String getCategory() {
	return category;
}


public String getName() {
	return name;
}

public double  getPrice() {
	return price;
}

public String getDescription() {
	return description;
}

public String getImage() {
	return image;
}

public void setId(int id) {
	this.id = id;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public void setCategory(String category) {
	this.category = category;
}

public void setName(String name) {
	this.name = name;
}

public void setPrice(double price) {
	this.price = price;
}

public void setImage(String img) {
	this.image = img;
}

public void setDescription(String desc) {
	this.description = desc;
}


}
