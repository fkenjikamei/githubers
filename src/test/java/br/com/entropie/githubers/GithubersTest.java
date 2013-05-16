package br.com.entropie.githubers;

import static org.junit.Assert.*;

import org.junit.Test;

public class GithubersTest {

	@Test
	public void test() {
		String url = String
				.format("https://api.github.com/legacy/user/search/location:brasil?start_page=1");
		String json = Requests.get(url);
		System.out.println(json);
		assertNotNull(json);
	}
}
