package br.com.entropie.githubers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Requests {

	public static String get(String urlString) {
		// Scanner s = null;
		// URL url = null;
		// InputStreamReader is = null;
		//
		// try {
		// url = new URL(urlString);
		// is = new InputStreamReader(url.openStream());
		// s = new Scanner(is);
		//
		// return s.next();
		// } catch (Exception e) {
		// e.printStackTrace();
		// throw new RuntimeException("Unable to download the user list =( ");
		// } finally {
		// s.close();
		// }

		BufferedReader reader = null;

		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} catch (Exception e) {
			System.out.println("url -> " + urlString);
			e.printStackTrace();
//			throw new RuntimeException("Unable to download the user list =( ");
			return null;
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
