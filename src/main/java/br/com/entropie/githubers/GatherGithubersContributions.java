package br.com.entropie.githubers;

import java.util.ArrayList;
import java.util.List;

import br.com.entropie.githubers.export.CSVOutput;
import br.com.entropie.githubers.model.Project;
import br.com.entropie.githubers.model.User;
import br.com.entropie.githubers.model.Users;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GatherGithubersContributions {

	private static final String REPO_API = "https://api.github.com/users/%s/repos%s";
	private static final String USERS_API = "https://api.github.com/users/";
	private static final String TOKEN = "?access_token=914f27563c751aa8a129216ff0f5427f005dc75c";

	private final Gson gson = new Gson();
	private final CSVOutput output = new CSVOutput();
	private final GatherIndividualContribuitions contributions = new GatherIndividualContribuitions();

	public void download(Users users) {
		List<User> githubers = new ArrayList<>();
		try {
			System.out.println("Total of: " + users.total());

			int i = 0;
			for (User user : users.getUsers()) {

				String login = user.getLogin();
				
				User newUser = new Gson().fromJson(getPersonalInfo(login), User.class);
				newUser = contributions.from(user);
				newUser.setLanguage(user.getLanguage());

				Project[] project = gson.fromJson(getProjectsInfo(login), Project[].class);
				newUser.setProjects(project);

				githubers.add(user);
				System.out.format("User %s.. Done!\n", user.getLogin());
				if (i == 10) {
					break;
				}
				i++;
			}

			output.saveAsCSV(githubers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getProjectsInfo(String login) {
		String url = String.format(REPO_API, login, TOKEN);
		return Requests.get(url);
	}

	private String getPersonalInfo(String login) {
		String url = USERS_API + login + TOKEN;
		String out = Requests.get(url);
		return out;
	}

	public static void main(String[] args) {
		String json = IOUtils.read(Dir.ROOT + "githubers.json");
		Users users = new Gson().fromJson(json, Users.class);
		long inicio = System.currentTimeMillis();
		new GatherGithubersContributions().download(users);
		long fim = System.currentTimeMillis();

		System.out.println("tempo: " + ((fim - inicio) / 1000) + "s");
	}
}