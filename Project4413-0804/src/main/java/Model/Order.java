package Model;


//orderDetails variables
public class Order {
private int id;
private String QtyList;
private double total;
private String itemList;
private String priceList;

public long getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getQtyList() {
	return QtyList;
}
public void setQtyList(String qtyList) {
	QtyList = qtyList;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public String getItemList() {
	return itemList;
}
public void setItemList(String itemList) {
	this.itemList = itemList;
}
public String getPriceList() {
	return priceList;
}
public void setPriceList(String priceList) {
	this.priceList = priceList;
}

// --------------------------------------------------------------------

// !! This is not User Model !!, these elements are used to send a object 
// from AdminViewDAO to ProcessCheckOut.java from JSON

//order variables
private String user;
private int addressId;
private int payId;
private String date;




public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public int getAddressId() {
	return addressId;
}
public void setAddressId(int addressId) {
	this.addressId = addressId;
}
public int getPayId() {
	return payId;
}
public void setPayId(int payId) {
	this.payId = payId;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}



}
