package cn.itcast.ssm.pojo;

// 购物车类
public class Shopcart {
	private Integer userId;	//用户id
	private Integer bookId;	//书id
	private Integer bookNumber;	//书的数量
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(Integer bookNumber) {
		this.bookNumber = bookNumber;
	}	
	
}
