package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class FileReader {

	public static List<String> readWords() {
		List<String> result = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("liste_francais.txt")))) {
			String line;
			while ((line = br.readLine()) != null) {
				result.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
