package Model;

import java.util.List;

public class Order {
private long id;
private String date;
private long total;
private List<Product> orderList;


public long getId() {
	return id;
}

public List<Product> getOrderList() {
	return orderList;
}

public String getDate() {
	return date;
}

public long getTotal() {
	return total;
}

public void setId(long id) {
	this.id = id;
}

public void setOrderList(List<Product> orderList) {
	this.orderList = orderList;
}

public void setDate(String date) {
	this.date = date;
}

public void setTotal(long total) {
	this.total = total;
}



}
