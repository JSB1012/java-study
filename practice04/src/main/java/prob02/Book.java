package prob02;

public class Book {
	private int stateCode = 1; // 0: 대여중, 1: 재고있음
	private int bookNo;
	private String title;
	private String author;

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNO(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book(int bookNo, String title, String author) {
		this.stateCode = 1;
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
	}

	public void print() {
		String state = "";
		if (getStateCode() == 1) {
			state = "재고있음";
		} else if (getStateCode() == 0) {
			state = "대여중";
		}
		System.out.println("책 제목:" + getTitle() + ", 작가:" + getAuthor() + ", 대여 유무:" + state);

	}

	public void rent() {
		this.stateCode = 0;
		System.out.println(getTitle() + "이(가) 대여 됐습니다.");
	}

}
