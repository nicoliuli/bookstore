package cn.itcast.ssm.pojo;

//订单表
public class Item {
	private int userId;	//用户id
	private int bookId;	//书id
	private String bookName;
	private int bookNum;	//书的数量
	private double bookPrice;	//书的价钱
	private int status;	//订单的状态（1发货，0代发货）
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBookNum() {
		return bookNum;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}
