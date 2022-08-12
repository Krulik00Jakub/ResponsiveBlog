package Mod;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;


/**
 * The <class>Modular</class> class takes filepath info, and outputs the info in the file.
 * The purpose of this class is to make certain elements of a webpage modular and allow
 * java servlets/JSP to decide when and where to insert them.
 * @author Jakub
 *
 */
public class Articles implements Comparable<Articles> {
	
	
	static class Page implements Comparable<Page> {
		String article;
		String name;
		LocalDate date;
		
		public Page(String article, String name) {
			this.name = name;
			this.date = LocalDate.parse(article.split("\n")[0]);
			this.article = article.replace(date.toString() + "\n\n", "");
		}

		@Override
		public int compareTo(Page o) {
			return this.date.compareTo(o.date);
		}
	}
	
	
	private BufferedReader topNav;
	private List <BufferedReader> content; // file contents
	private List <Page> articles;
	private List <File> files; // file paths
	Path path;
	
	/**
	 * Constructor fills the variables with the HTML information about
	 * the top navigation bar of the website, and a list of posts sorted by filename.
	 * @param topNav
	 * @param content
	 * @throws IOException
	 */
	public Articles(String content) throws IOException {
		this.topNav = Files.newBufferedReader(Paths.get(
				"C:\\Users\\Jakub\\eclipse-workspace\\Sinoling\\src\\main\\webapp\\nav.html"));
		
		this.content = new ArrayList<BufferedReader>();
		this.articles = new ArrayList<Page>();
		List<File> files = Files.list(Paths.get(content))
			    .map(Path::toFile)
			    .filter(File::isFile)
			    .collect(Collectors.toList());
	
		
		Collections.sort(files);
		
		this.files = files;
		
		for (int i = 0; i < files.size(); i++) {
			this.content.add(Files.newBufferedReader(Paths.get(content + files.get(i).getName())));
		}
		
		for (int i = 0; i < this.content.size(); i++) {
			this.articles.add(new Page(this.content.get(i).lines().collect(Collectors.joining("\n")), this.files.get(i).getName()));
		}
	}
	
	public String topNav() throws IOException {
		return topNav.lines().collect(Collectors.joining());
	}
	
	private static StringBuffer toHTML(String s) {
		
		ArrayList<String> t = new ArrayList<>();
		Collections.addAll(t, s.split("\n"));
		StringBuffer buf = new StringBuffer(
				"<div class=\"paragraph\"><h1>" + t.remove(0).toString() + "</h1>");
		
		for (int i = 0; i < t.size(); i++) {
			buf.append("<p>" + t.get(i).toString() + "</p>");
		}
		
		buf.append("</div>");
		
		return buf;
	}
	
	public String content(int i) throws IOException {
		return toHTML(articles.get(i).article).toString();
		//return content.get(i).lines().collect(Collectors.joining());
		//return content.lines().toString();
	}
	
	public String name(int i) {
		CharSequence m = articles.get(i).article.split("\n")[0];
		m.subSequence(0, m.length());
		return "<div><p>"+m.toString()+"</p></div>";
	} //fixed
	
	public String brief(int i) {
		CharSequence m = articles.get(i).article.split("\n")[2];
		m = m.subSequence(0, Math.min(m.length(), 150));
		return "<div><p>"+m.toString()+"..."+"</p></div>";
	}
	
	private String createElement(int i) throws IOException {
		StringBuffer buf = new StringBuffer();
		buf.append("<li>");
		buf.append("<a class=\"scrollmenu\" href="+this.files(i)+">");
		buf.append("<div class=\"element\">");
		//TO-DO
		
		buf.append("<h3>"+name(i)+"</h3>");
		buf.append("<p>"+brief(i)+"</p>");
		
		buf.append("</div>");
		buf.append("</a>");
		buf.append("</li>");
		
		return buf.toString();
	}
	
	public String htmList() throws IOException {
		StringBuffer buf = new StringBuffer();
		buf.append("<div class=\"list\">");
		buf.append("<ul>");
		
		for (int i = 0; i < files.size(); i++) {
			buf.append(createElement(i));
		}
		
		buf.append("</ul>");
		buf.append("</div>");
		
		return buf.toString();
	}

	public String files(int i) {
		return files.get(i).toString();
	}

	@Override
	public int compareTo(Articles o) {
		return this.articles.get(this.articles.size()).date.compareTo(o.articles.get(o.articles.size()).date);
	}
	
} 
