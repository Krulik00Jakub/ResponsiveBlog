package Mod;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;


/**
 * The <class>Modular</class> class takes filepath info, and outputs the info in the file.
 * The purpose of this class is to make certain elements of a webpage modular and allow
 * java servlets to decide when and where to insert them.
 * @author Jakub
 *
 */
public class Modular {
	private BufferedReader topNav;
	private BufferedReader content;
	private String name;
	Path path;
	
	/**
	 * Constructor fills the variables with the HTML information about
	 * the top navigation bar of the website, and a single post.
	 * @param topNav
	 * @param content
	 * @throws IOException
	 */
	public Modular(String content, String name) throws IOException {
		this.topNav = Files.newBufferedReader(Paths.get(
				"C:\\Users\\Jakub\\eclipse-workspace\\Sinoling\\src\\main\\webapp\\nav.html"));
		this.content = Files.newBufferedReader(Paths.get(content));
		this.name = name;
	}
	
	public String topNav() throws IOException {
		return topNav.lines().collect(Collectors.joining());
	}
	
	public String content() throws IOException {
		return content.lines().collect(Collectors.joining());
		//return content.lines().toString();
	}
	
	public String name() {
		return name;
	}
	
	public static void main(String args[]) {
		String s = "你好";
		System.out.println(s);
	}
}
