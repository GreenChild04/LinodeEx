package com.greenchild.green;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Gile {
	public String filename;

	public Gile(String filename) {
		this.filename = filename;
		this.createFile();
	}

	void createFile() {
		File file = new File(this.filename);
		try {
			file.createNewFile();
		} catch (IOException e) {
			Green.log("Error while creating file");
		}
	}

	public void write(String data) {
		try {
			FileWriter file = new FileWriter(this.filename);
			file.write(data);
			file.close();
		} catch (IOException e) {
			Green.log("Error while writing to file");
		}
	}

	//////////////////////////
	// Static Properties
	//////////////////////////

	public static String nohup(String cmd) {
		return "nohup " + cmd + " < /dev/null >> /home/minecraft/server/.log 2>&1 &";
	}

	public static void bash(String filename, String cmd) {
		Gile file = new Gile(filename);
		String contents = "#!/bin/bash\n\n" + cmd;
		file.write(contents);
		Green.execCmd("chmod +x " + filename);
	}
}
