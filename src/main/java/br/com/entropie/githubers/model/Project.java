package br.com.entropie.githubers.model;

public class Project {

	private long id;
	private boolean fork;
	private String created_at;
	private String updated_at;
	private String pushed_at;
	private int size;
	private int watchers_count;
	private String language;
	private boolean has_issues;
	private boolean has_downloads;
	private int open_issues_count;
	private int open_issues;
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
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
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
		return watchers_count;
	}

	public void setWatchers_count(int watchers_count) {
		this.watchers_count = watchers_count;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isHas_issues() {
		return has_issues;
	}

	public void setHas_issues(boolean has_issues) {
		this.has_issues = has_issues;
	}

	public boolean isHas_downloads() {
		return has_downloads;
	}

	public void setHas_downloads(boolean has_downloads) {
		this.has_downloads = has_downloads;
	}

	public int getOpen_issues_count() {
		return open_issues_count;
	}

	public void setOpen_issues_count(int open_issues_count) {
		this.open_issues_count = open_issues_count;
	}

	public int getOpen_issues() {
		return open_issues;
	}

	public void setOpen_issues(int open_issues) {
		this.open_issues = open_issues;
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
		String[] array = { login, fork + "", created_at, updated_at, pushed_at,
				size + "", watchers_count + "", language, has_issues + "",
				has_downloads + "", open_issues_count + "", open_issues + "",
				forks + "", watchers + "" };

		return array;
	}
}
