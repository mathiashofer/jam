package at.mhofer.jam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class OpCodeParser
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
		PrintStream out = new PrintStream(new FileOutputStream(args[1]));

		String line = null;
		while ((line = in.readLine()) != null)
		{
			String[] split = line.split("\\s+");
			String outStr = "public static final int " + split[2].toUpperCase() + " = " + split[1]
					+ ";";
			out.println();
			out.println(outStr);
		}
		in.close();
		out.flush();
		out.close();
		
	}
}
