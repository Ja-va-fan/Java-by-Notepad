import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.nio.file.Path;
import java.nio.charset.Charset;
import java.io.IOException;
import java.util.regex.Pattern;
import java.lang.InterruptedException;

public class HTML2MD {
	private static String usage = "You must provide the HTML file as argument";
	public static void main(String... args) throws IOException, InterruptedException {
		if (args.length == 0) {
			System.err.println(usage);
			System.exit(1);
		}
		Path path = FileSystems.getDefault().getPath(".", args[0]);
		byte[] bytes = Files.readAllBytes(path);
		String string = new String(bytes, StandardCharsets.UTF_8);

		string = string.replaceAll("\n", "\1");
		string = string.replaceAll("<html>\1*(.*)</html>", "$1");
		string = string.replaceAll("\\s*<head>(.*)</head>", "");
		string = string.replaceAll("\\s*<body>\1*(.*)</body>", "$1");
		string = string.replaceAll("\\s*<h1>(.*?)</h1>", "\1\1\1\1\1# $1");
		string = replaceHeadings(string);
		string = string.replaceAll("[\1\\s]*<p>(.*?)</p>", "\1\1$1");
		string = replaceBullets(string, "ul", "*");
		string = replaceBullets(string, "ol", "#.");
		string = string.replaceAll("\1", "\n");

		System.out.println(string);
	}

	private static String replaceHeadings(String string) {
		String crlf = "\1\1\1\1\1";
		String hashes = "######";
		for (int i=1; i<6; i++) {
			string = string.replaceAll("\\s*<h" + i + ">(.*?)</h" + i + ">", crlf.substring(i)+hashes.substring(0,i) + " $1");
		}
		return string;
	}

	private static String replaceBullets(String string, String tag, String bullet) {
		String bullets = null;
		while (string.matches(".*<" + tag + ">.*")) {
			bullets = string.replaceFirst("(.*?)<" + tag + ">(.*?)</" + tag + ">(.*)", "$2");
			bullets = bullets.replaceAll("[\1\\s]*<li>(.*?)</li>", "\1" + bullet + " $1");
			string = string.replaceFirst("[\1\\s]*<" + tag + ">(.*?)</" + tag + ">", "\1" + bullets);
		}
		return string;
	}

}
