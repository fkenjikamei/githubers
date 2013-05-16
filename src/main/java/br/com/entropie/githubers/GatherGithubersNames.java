package br.com.entropie.githubers;

import java.util.ArrayList;
import java.util.List;

import br.com.entropie.githubers.model.User;
import br.com.entropie.githubers.model.Users;

import com.google.gson.Gson;

public class GatherGithubersNames {

	private static final String ROOT = "https://api.github.com/legacy/user/search/location:";
	private static final String TOKEN = "&access_token=914f27563c751aa8a129216ff0f5427f005dc75c";

	public void download() {
		Gson gson = new Gson();
		List<String> locations = Locations.get();
		List<User> users = new ArrayList<>();

		try {

			for (int page = 1; page <= 10; page++) {
				System.out.println("Page: " + page);
				for (String location : locations) {

					System.out.println("Location: " + location);
					String url = String.format("%s%s?start_page=%s%s", ROOT,
							location, page, TOKEN);

					String json = Requests.get(url);
					Users data = gson.fromJson(json, Users.class);
					if (data != null) {
						users.addAll(data.getUsers());
					} else {
						System.out.println("no_user_found");
					}
				}
			}

			IOUtils.write(Dir.ROOT + "githubers.json", gson.toJson(users));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		new GatherGithubersNames().download();
		long fim = System.currentTimeMillis();

		System.out.println("tempo: " + ((fim - inicio) / 1000) + "s");
	}
}
