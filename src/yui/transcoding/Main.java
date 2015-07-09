package yui.transcoding;

import java.io.File;
import java.util.Scanner;

// GBK编码转换成UTF-8编码
public class Main {

	private static String rootPath = "G:\\Projects\\JavaSE\\Yui-net\\src";

	public static void start(String path) {
		System.out.println(path);
		File rootFile = new File(path);
		File[] files = rootFile.listFiles();
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (file.isDirectory()) {
				start(file.getPath());
			} else {
				String p = file.getParent().substring(rootPath.length());
				File targetFile = new File(rootPath + "-bk/" + p);
				if (!targetFile.exists()) {
					targetFile.mkdirs();
				}
				if (file.getName().endsWith(".java")) {
					Coding.coding(file.toString(),
							targetFile + "/" + file.getName());
				} else {
					file.renameTo(new File(targetFile + "/" + file.getName()));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		rootPath = scan.nextLine();
		start(rootPath);
		scan.close();
	}
}
