package Practice_21_22;

import java.util.List;
import java.util.Scanner;

public interface ItemStore {
	List<Item> getAll();
	Item get(int id);
	Item addItem(Item item);
	void editItem(Item item, int id);
	void deleteItem(Item item);
	default void execApp() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("What should I do?\n" +
					"1|	Get all objects\n" +
					"2|	Get one object\n" +
					"3|	Edit object\n" +
					"4|	Add object\n" +
					"5|	Delete object");
			int choice = Integer.parseInt(in.nextLine());
			switch (choice) {
				case 1:
					for (Item item : getAll()) {
						System.out.println(item);
					}
					break;
				case 2:
					System.out.println("Enter object id");
					System.out.println(get(Integer.parseInt(in.nextLine())).toString());
					break;
				case 3:
					boolean condition = true;
					System.out.println("Enter object id");
					int oldId = Integer.parseInt(in.nextLine());
					Item currentItem = get(oldId);
					while (condition) {
						System.out.println("What u wanna edit?\n" +
								"1|	id, current value( " + currentItem.getId() + " )\n" +
								"2|	data, current value( " + currentItem.getData() + " )\n" +
								"3|	isGood, current value( " + currentItem.isGood() + " )\n" +
								"4|	description, current value( " + currentItem.getDescription() + " )\n" +
								"Type number or name.");
						String editing = in.nextLine();
						if (editing.equals("1") || editing.equals("id")) {
							System.out.println("Type new id");
							Scanner scanner = new Scanner(System.in);
							currentItem.setId(scanner.nextInt());
						} else if (editing.equals("2") || editing.equals("data")) {
							System.out.println("Type new data");
							Scanner scanner = new Scanner(System.in);
							currentItem.setData(scanner.nextLine());
						} else if (editing.equals("3") || editing.equals("isGood")) {
							System.out.println("Type new isGood");
							Scanner scanner = new Scanner(System.in);
							currentItem.setGood(scanner.nextBoolean());
						} else if (editing.equals("4") || editing.equals("description")) {
							System.out.println("Type new description");
							Scanner scanner = new Scanner(System.in);
							currentItem.setDescription(scanner.nextLine());
						} else {
							System.out.println("I don't understand ur humor");
						}
						editItem(currentItem, oldId);
						System.out.println("Current object is\n" + currentItem.toString());
						System.out.println("Do u wanna continue editing?\n(true or false)");
						condition = Boolean.parseBoolean(in.nextLine());
					}
					break;
				case 4:
					System.out.println("Enter information about item in the next case\n \"id\"\n \"data\"\n \"isGood\"\n \"description\"");
					try {
						int id = Integer.parseInt(in.nextLine());
						String data = in.nextLine();
						boolean isGood = Boolean.parseBoolean(in.nextLine());
						String description = in.nextLine();
						Item newItem = new Item(id, data, isGood, description);
						System.out.println("Object " + addItem(newItem).toString() + " added");
					} catch (NumberFormatException e) {
						System.out.println("Stop play with me, prankster");
						return;
					}
					break;
				case 5:
					System.out.println("Enter id");
					deleteItem(get(Integer.parseInt(in.nextLine())));
					System.out.println("Object was deleted");
					break;
				default:
					System.out.println("Thanks for using prankster. Try again.");
			}
		}
	}

}
