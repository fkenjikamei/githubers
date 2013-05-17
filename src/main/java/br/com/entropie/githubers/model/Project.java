package br.com.entropie.githubers.model;

public class Project {

	private long id;
	private boolean fork;
	private String createdAt;
	private String updatedAt;
	private String pushed_at;
	private int size;
	private int watchersCount;
	private String language;
	private boolean hasIssues;
	private boolean hasDownloads;
	private int openIssuesCount;
	private int openIssues;
	private int forks;
	private int watchers;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isFork() {
		return fork;
	}

	public void setFork(boolean fork) {
		this.fork = fork;
	}

	public String getCreated_at() {
		return createdAt;
	}

	public void setCreated_at(String created_at) {
		this.createdAt = created_at;
	}

	public String getUpdated_at() {
		return updatedAt;
	}

	public void setUpdated_at(String updated_at) {
		this.updatedAt = updated_at;
	}

	public String getPushed_at() {
		return pushed_at;
	}

	public void setPushed_at(String pushed_at) {
		this.pushed_at = pushed_at;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWatchers_count() {
		return watchersCount;
	}

	public void setWatchers_count(int watchers_count) {
		this.watchersCount = watchers_count;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isHas_issues() {
		return hasIssues;
	}

	public void setHas_issues(boolean has_issues) {
		this.hasIssues = has_issues;
	}

	public boolean isHas_downloads() {
		return hasDownloads;
	}

	public void setHas_downloads(boolean has_downloads) {
		this.hasDownloads = has_downloads;
	}

	public int getOpen_issues_count() {
		return openIssuesCount;
	}

	public void setOpen_issues_count(int open_issues_count) {
		this.openIssuesCount = open_issues_count;
	}

	public int getOpen_issues() {
		return openIssues;
	}

	public void setOpen_issues(int open_issues) {
		this.openIssues = open_issues;
	}

	public int getForks() {
		return forks;
	}

	public void setForks(int forks) {
		this.forks = forks;
	}

	public int getWatchers() {
		return watchers;
	}

	public void setWatchers(int watchers) {
		this.watchers = watchers;
	}

	public String[] toArray(String login) {
		String[] array = { login, fork + "", createdAt, updatedAt, pushed_at,
				size + "", watchersCount + "", language, hasIssues + "",
				hasDownloads + "", openIssuesCount + "", openIssues + "",
				forks + "", watchers + "" };

		return array;
	}
}
