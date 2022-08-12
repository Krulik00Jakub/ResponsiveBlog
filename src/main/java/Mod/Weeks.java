package Mod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class implements sorting of articles by week for representation on webpage.
 * @author Jakub
 *
 */
public class Weeks {
	List<Articles> weeks;
	File file; //directory where all week files are stored
	
	public Weeks(String file) throws IOException {
		
		List<File> files = Files.list(Paths.get(file))
			    .map(Path::toFile)
			    .filter(File::isFile)
			    .collect(Collectors.toList());
		
		weeks = new ArrayList<>();
		
		files.forEach(f -> {
			try {
				weeks.add(new Articles(f.toString()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Collections.sort(weeks);
	}
}
