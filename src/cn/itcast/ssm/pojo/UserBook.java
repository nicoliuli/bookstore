package cn.itcast.ssm.pojo;

//pojo包装类
//用于加入购物车,查询本用户购物车中是否有当前要购买的书
public class UserBook {
	private Integer user_id;	//用户id
	private Integer book_id;	//书id
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer userId) {
		user_id = userId;
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer bookId) {
		book_id = bookId;
	}	
}
