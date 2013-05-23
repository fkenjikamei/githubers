package br.com.entropie.githubers;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import br.com.entropie.githubers.model.User;

import com.google.gson.Gson;

public class GatherIndividualContribuitions {

	private static final String GITHUB = "https://github.com/";

	public User from(User user) {
		String url = null;
		try {
			if (user == null) {
				System.out.println("user null");
				return new User();
			}

			url = GITHUB + user.getLogin();
			Document doc = Jsoup.connect(url).get();
			Elements es = doc.getElementsByClass("num");

			if (es.size() > 0) {
				user.setYearOfContributions(es.get(0).text().split(" ")[0]);
				user.setLongestStreak(es.get(1).text().split(" ")[0]);
				user.setCurrentStreak(es.get(2).text().split(" ")[0]);

				addContributions(user);
			}

			return user;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("url -> " + url);
			return new User();
		}
	}

	private void addContributions(User user) throws IOException {

		for (int i = 0; i < 12; i++) {

			int fromMonth = (5 + i);
			int toMonth = (6 + i);

			int fromYear = 2012;
			int toYear = 2012;

			if (fromMonth > 12) {
				fromMonth = fromMonth - 12;
				fromYear = 2013;
			}

			if (toMonth > 12) {
				toMonth = toMonth - 12;
				toYear = 2013;
			}

			String fMonth = String.valueOf(fromMonth < 10 ? "0" + fromMonth : fromMonth);
			String tMonth = String.valueOf(toMonth < 10 ? "0" + toMonth : toMonth);

			String periodo = String.format(
					"?tab=contributions&from=%s-%s-31&to=%s-%s-31", fromYear, fMonth, toYear, tMonth);

			String url = GITHUB + user.getLogin() + periodo;
			
//			System.out.println(url);

			try {

				Document doc = Jsoup.connect(url).get();

				int commits = extractContribution(doc, 0);
				int pullRequests = extractContribution(doc, 1);
				int issuesReported = extractContribution(doc, 2);

				user.addCommits(i, commits);
				user.addPullRequests(i, pullRequests);
				user.addIssuesReported(i, issuesReported);

			} catch (IOException e) {
				System.out.println("url -> " + url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private int extractContribution(Document doc, int contribution) {
		Elements elements = doc.getElementsByClass("conversation-list-heading")
				.select("div");

		for (int i = 0; i < elements.size(); i++) {
			String value = elements.get(i).text();

			if (contribution == 0 && value.contains("Commits")) {
				String metric = Jsoup.parse(value).text();
				return Integer.parseInt(metric.split(" ")[0]);
			} else if (contribution == 1 && value.contains("Pull Requests")) {
				String metric = Jsoup.parse(value).text();
				return Integer.parseInt(metric.split(" ")[0]);
			} else if (contribution == 2 && value.contains("Issue Reported")) {
				String metric = Jsoup.parse(value).text();
				return Integer.parseInt(metric.split(" ")[0]);
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		User user = new User();
		user.setLogin("paulocheque");
		user = new GatherIndividualContribuitions().from(user);
		System.out.println(new Gson().toJson(user));
	}
}
