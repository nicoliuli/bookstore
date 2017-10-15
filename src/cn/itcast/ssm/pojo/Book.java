package cn.itcast.ssm.pojo;

import java.io.Serializable;



public class Book implements Serializable{	//可序列化，二级缓存
	private Integer id;	//数id
	private String bookName;	//书名
	private String author;	//作者
	private double price;	//价格
	private String descripse;	//描述
	private Shopcart shopCart;	//购买的数量
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescripse() {
		return descripse;
	}
	public void setDescripse(String descripse) {
		this.descripse = descripse;
	}
	public Shopcart getShopCart() {
		return shopCart;
	}
	public void setShopCart(Shopcart shopCart) {
		this.shopCart = shopCart;
	}
	
}
