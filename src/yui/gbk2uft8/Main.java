package yui.gbk2uft8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

// GBK编码转换成UTF-8编码
public class Main {

	private static String rootPath = "G:\\Projects\\JavaSE\\Yui\\src";

	public static void start(String path) {
		File rootFile = new File(path);
		File[] files = rootFile.listFiles();
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (file.isDirectory()) {
				start(file.getPath());
			} else {
				BufferedReader reader = null;
				PrintWriter writer = null;
				try {
					FileInputStream in = new FileInputStream(file);

					String p = file.getParent().substring(rootPath.length());
					File targetFile = new File(rootPath + "-bk/" + p);
					if (!targetFile.exists()) {
						targetFile.mkdirs();
					}
					reader = new BufferedReader(
							new InputStreamReader(in, "GBK"));
					writer = new PrintWriter(targetFile + "/" + file.getName(),"UTF-8");
					String line = null;
					while ((line = reader.readLine()) != null) {
						writer.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					writer.close();
					if (reader != null) {
						try {
							reader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		start(rootPath);
	}
}
