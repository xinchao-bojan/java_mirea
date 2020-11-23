package Practice_21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocalFile implements ItemStore {

	private File jsonFile = new File("D:\\java practice\\java\\Java_MIREA\\src\\main\\java\\Practice_21_22\\data.json");
	Gson gson = new Gson();

	@Override
	public List<Item> getAll() {
		String text;
		StringBuilder sb = new StringBuilder();
		ArrayList<Item> items = new ArrayList<>();
		Type collectionType = new TypeToken<Collection<Item>>() {
		}.getType();
		try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
			text = reader.readLine();
			while (text != null) {
				sb.append(text + "\n");
				text = reader.readLine();
			}
			items = gson.fromJson(sb.toString(), collectionType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public Item get(int id) {
		Item item = null;
		for (Item buf : getAll()) {
			if (buf.getId() == id) {
				item = buf;
				break;
			}
		}
		return item;
	}

	@Override
	public Item addItem(Item item) {
		StringBuilder sb = new StringBuilder();
		String line;
		if (!checkId(item.getId())) {
			try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
				line = reader.readLine();
				while (!line.equals("]") && line != null) {
					sb.append(line);
					if (line.endsWith("}"))
						sb.append(",");
					sb.append("\n");
					line = reader.readLine();

				}
				sb.append(gson.toJson(item));
				try (PrintWriter writer = new PrintWriter(jsonFile)) {
					writer.write(sb.toString() + "\n]");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return item;
		}
		return null;
	}

	@Override
	public void editItem(Item item, int id) {
		deleteItem(get(id));
		addItem(item);
	}

	@Override
	public void deleteItem(Item item) {
		StringBuilder sb = new StringBuilder();
		int index = getAll().size();
		int count = 0;
		String line;
		Item item1;
		if (checkId(item.getId())) {
			try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
				line = reader.readLine();
				sb.append("[\n");
				while (line != null) {
					if (isCorrect(line) || line.endsWith("},")) {
						item1 = gson.fromJson(line.substring(line.indexOf("{"), line.indexOf("}") + 1), Item.class);
						if (item1.getId() != item.getId()) {
							sb.append(line.substring(line.indexOf("{"), line.indexOf("}") + 1));
							if (count < index - 2) {
								sb.append(",");
							}
							sb.append("\n");
							count++;
						}
					}
					line = reader.readLine();
				}
				sb.append("]");
				try (PrintWriter writer = new PrintWriter(jsonFile)) {
					writer.write(sb.toString());
				}
			} catch (IOException e) {
				e.getStackTrace();
			}
		}

	}

	private boolean checkId(int id) {
		if (get(id) != null) {
			return true;
		}
		return false;
	}

	public boolean isCorrect(String js) {
		try {
			gson.fromJson(js, Object.class);
			return true;
		} catch (com.google.gson.JsonSyntaxException ex) {
			return false;
		}
	}
}
