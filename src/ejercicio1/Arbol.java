package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Arbol {
	public static void main(String[] args)  {
		String username = System.getProperty("user.name");
		String path = new String("C:\\Users\\" + username + "\\");
		File dirStructure = new File("src/ejercicio1/carpetas.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(dirStructure));
			String line;
			if (dirStructure.exists()) {
				while((line = br.readLine()) != null) {
					File directorio = new File(path + line);
					boolean created = directorio.mkdirs();
					if (created) {
						System.out.println("Directorio creado: " + directorio.getAbsolutePath());
					}else {
						System.out.println("No se ha podido crear el directorio " + directorio.getName() + ".");
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(dirStructure.getAbsolutePath());
			System.err.println("No se ha encontrado el fichero con las carpetas.");
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
