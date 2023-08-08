package Model;

public class Product {
	
private Long id;
private String category;
private String name;
private Long price;
private String img;
private String desc;



public Long getId() {
	return id;
}

public String getCategory() {
	return category;
}


public String getName() {
	return name;
}

public Long getPrice() {
	return price;
}

public String getDesc() {
	return desc;
}

public String getImg() {
	return img;
}

public void setId(Long id) {
	this.id = id;
}

public void setCategory(String category) {
	this.category = category;
}

public void setName(String name) {
	this.name = name;
}

public void setPrice(Long price) {
	this.price = price;
}

public void setImg(String img) {
	this.img = img;
}

public void setDesc(String desc) {
	this.desc = desc;
}


}
