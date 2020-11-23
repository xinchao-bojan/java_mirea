package Practice_21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.List;


public class Server implements ItemStore {

	HttpClient httpClient = HttpClient.newHttpClient();
	Gson gson = new Gson();

	@Override
	public List<Item> getAll() {
		List<Item> items = null;
		try {
			Type collectionType = new TypeToken<Collection<Item>>() {
			}.getType();
			HttpRequest request = HttpRequest.newBuilder()
					.GET()
					.uri(URI.create("http://80.87.199.76:3000/objects"))
					.build();
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			items = gson.fromJson(response.body(), collectionType);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public Item get(int id) {
		Item item = null;
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.GET()
					.uri(URI.create("http://80.87.199.76:3000/objects/" + id))
					.build();
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			item = gson.fromJson(response.body(), Item.class);
			System.out.println(gson.fromJson(response.body(), Item.class));
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public Item addItem(Item item) {
		String body = gson.toJson(item);
		HttpRequest request = HttpRequest.newBuilder()
				.POST(HttpRequest.BodyPublishers.ofString(body))
				.uri(URI.create("http://80.87.199.76:3000/objects/"))
				.setHeader("Content-Type", "application/json")
				.build();
		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void editItem(Item item, int id) {
		try {
			String body = gson.toJson(item);
			HttpRequest request = HttpRequest.newBuilder()
					.PUT(HttpRequest.BodyPublishers.ofString(body))
					.uri(URI.create("http://80.87.199.76:3000/objects/" + id))
					.setHeader("Content-Type", "application/json")
					.build();
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteItem(Item item) {
		HttpRequest request = HttpRequest.newBuilder()
				.DELETE()
				.uri(URI.create("http://80.87.199.76:3000/objects/" + item.getId()))
				.build();
		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
