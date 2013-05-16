package br.com.entropie.githubers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class IOUtils {

	public static String read(String filename) {
		Scanner s = null;
		try {
			s = new Scanner(new FileInputStream(filename));
			return s.nextLine();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			s.close();
		}
	}

	public static void write(String filename, String content) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);

			fos.write(content.getBytes());
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		IOUtils.read(Dir.ROOT + "githubers_2.txt");
	}
}
