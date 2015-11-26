package uk.co.manifesto.camel.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	public static String read(String path) throws FileNotFoundException{
		
		Scanner s = new Scanner(new File(path));
		StringBuilder sb = new StringBuilder();
		while (s.hasNextLine()) {
			sb.append(s.nextLine());
		}
		s.close();

		return sb.toString();
		
	}
	
}
