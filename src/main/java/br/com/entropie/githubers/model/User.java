package br.com.entropie.githubers.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;

public class User {
	private String login;
	private String company;
	private String location;
	private String language;
	private boolean hireable;

	@SerializedName("public_repos")
	private int public_repos;
	private int followers;
	private int following;
	private String yearOfContributions = "0";
	private String longestStreak = "0";
	private String currentStreak = "0";
	private Map<Integer, Integer> commits;
	private Map<Integer, Integer> pullRequests;
	private Map<Integer, Integer> issuesReported;
	private Project[] projects;

	public void addCommits(int month, int value) {
		if (commits == null) {
			commits = new HashMap<>();
		}
		commits.put(month, value);
	}

	public void addPullRequests(int month, int value) {
		if (pullRequests == null) {
			pullRequests = new HashMap<>();
		}
		pullRequests.put(month, value);
	}

	public void addIssuesReported(int month, int value) {
		if (issuesReported == null) {
			issuesReported = new HashMap<>();
		}
		issuesReported.put(month, value);
	}

	private String[] formatContribuition(Map<Integer, Integer> contribution) {
		List<String> output = Lists.newArrayList(login);
		if (contribution != null) {
			Set<Integer> keys = contribution.keySet();
			for (Integer key : keys) {
				Integer value = contribution.get(key);
				output.add(String.valueOf(value));
			}
		}
		return output.toArray(new String[0]);
	}

	public String[] getCommits() {
		return formatContribuition(commits);
	}

	public String[] getPullRequests() {
		return formatContribuition(pullRequests);
	}

	public String[] getIssuesReported() {
		return formatContribuition(issuesReported);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isHireable() {
		return hireable;
	}

	public void setHireable(boolean hireable) {
		this.hireable = hireable;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public int getFollowing() {
		return following;
	}

	public void setFollowing(int following) {
		this.following = following;
	}

	public String getYearOfContributions() {
		return yearOfContributions;
	}

	public void setYearOfContributions(String yearOfContributions) {
		this.yearOfContributions = yearOfContributions;
	}

	public String getLongestStreak() {
		return longestStreak;
	}

	public void setLongestStreak(String longestStreak) {
		this.longestStreak = longestStreak;
	}

	public String getCurrentStreak() {
		return currentStreak;
	}

	public void setCurrentStreak(String currentStreak) {
		this.currentStreak = currentStreak;
	}

	public int getPublic_repos() {
		return public_repos;
	}

	public void setpublic_repos(int public_repos) {
		this.public_repos = public_repos;
	}

	public String toString() {
		return "(" + login + ", " + language + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	public Project[] getProjects() {
		return projects;
	}

	public void setProjects(Project[] projects) {
		if (projects == null) {
			projects = new Project[1];
			projects[0] = new Project();
		}
		this.projects = projects;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	public String[] toArray() {
		String[] array = { login, company, location, language, hireable + "",
				public_repos + "", followers + "", following + "",
				yearOfContributions, longestStreak, currentStreak };

		return array;
	}
}
