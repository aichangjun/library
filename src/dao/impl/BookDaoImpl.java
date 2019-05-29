package dao.impl;

import java.util.List;

import dao.BaseDao;
import dao.BookDao;
import entity.Book;

public class BookDaoImpl extends BaseDao implements BookDao {

	
	public static void main(String[] args) {
	BookDao dao=new BookDaoImpl();
	System.out.println(dao.queryAll());
	
	}
	
	
	@Override
	public List<Book> queryAll() {
		String sql="select * from book";
		
		return executeQuery(sql,Book.class);
	}

	@Override
	public int insert(Book book) {
		String sql = "insert into book(bname,author,price) values(?,?,?)";
		return executeUpdate(sql,book.getBname(),book.getAuthor(),book.getPrice());
	}

	@Override
	public int update(Book book) {
		String sql = "update book set bname=?,author=?,price=? where bid=?";
		return executeUpdate(sql,book.getBname(),book.getAuthor(),book.getPrice());
	}

	@Override
	public int delete(int bid) {
		String sql = "delete from book where bid =?";
		return executeUpdate(sql,bid);
	}

}
