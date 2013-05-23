package br.com.entropie.githubers.export;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;
import br.com.entropie.githubers.Dir;
import br.com.entropie.githubers.model.Project;
import br.com.entropie.githubers.model.User;

public class CSVOutput {

	public void saveAsCSV(List<User> users) {
		try {
			saveSingleFile(users);
			saveProjects(users);
			saveCommitFile(users);
			savePullRequestsFile(users);
			saveIssuesFile(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void saveProjects(List<User> users) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(Dir.ROOT
				+ "githubers_projects.csv"), ';');

		String[] titles = { "user_id", "project", "fork", "created_at", "updated_at",
				"pushed_at", "size", "watchers_count", "language",
				"has_issues", "has_downloads", "open_issues_count",
				"open_issues", "forks", "watchers" };

		writer.writeNext(titles);

		for (User user : users) {
			Project[] projects = user.getProjects();

			for (Project project : projects) {
				writer.writeNext(project.toArray(user));
			}
		}

		writer.close();
	}

	private void saveIssuesFile(List<User> users) throws IOException {
		List<String[]> content = new ArrayList<>();
		for (User user : users) {
			String[] issues = user.getIssuesReported();
			content.add(issues);
		}
		saveExtraFile(content, Dir.ROOT + "githubers_issues.csv");
	}

	private void savePullRequestsFile(List<User> users) throws IOException {
		List<String[]> content = new ArrayList<>();
		for (User user : users) {
			String[] pullRequets = user.getPullRequests();
			content.add(pullRequets);
		}
		saveExtraFile(content, Dir.ROOT + "githubers_pull_requests.csv");
	}

	private void saveCommitFile(List<User> users) throws IOException {
		List<String[]> content = new ArrayList<>();
		for (User user : users) {
			String[] commits = user.getCommits();
			content.add(commits);
		}
		saveExtraFile(content, Dir.ROOT + "githubers_commits.csv");
	}

	private void saveExtraFile(List<String[]> content, String file)
			throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(file), ';');

		String[] titles = { "User", "May/2012", "Jun/2012", "Jul/2012",
				"Ago/2012", "Sep/2012", "Oct/2012", "Nov/2012", "Dec/2012",
				"Jan/2013", "Feb/2013", "Mar/2013", "Apr/2013" };

		writer.writeNext(titles);
		writer.writeAll(content);
		writer.close();
	}

	private void saveSingleFile(List<User> users) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(Dir.ROOT
				+ "githubers.csv"), ';');

		String[] titles = { "login", "company", "location", "language",
				"hireable", "public_repos", "followers", "following",
				"yearOfContributions (total)", "longestStreak (days)",
				"currentStreak (days)" };

		writer.writeNext(titles);

		for (User user : users) {
			if (user != null) {
				writer.writeNext(user.toArray());
			}
		}

		writer.close();
	}
}