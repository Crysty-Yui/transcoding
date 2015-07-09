package yui.transcoding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Coding {

	public static void coding(String resource, String target) {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			FileInputStream in = new FileInputStream(resource);

			reader = new BufferedReader(new InputStreamReader(in, "GBK"));
			writer = new PrintWriter(target, "UTF-8");
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
