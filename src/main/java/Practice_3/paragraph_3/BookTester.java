package Practice_3.paragraph_3;

public class BookTester {
	public static void main(String[] args) {
		Book book=new Book();
		System.out.println("Start properties:\nAuthor is "+book.getAuthor()+"\nThe name is "+ book.getName()+"\nThe date of publishing is "+book.getDate());
		book.setAuthor("lil krystalll");
		book.setDate(2020);
		book.setName("Off-White_airforce_color_of_cabbage");
		System.out.println("New properties:\nAuthor is "+book.getAuthor()+"\nThe name is "+ book.getName()+"\nThe date of publishing is "+book.getDate());
	}

}
