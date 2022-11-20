package org.green;
import io.papermc.paperclip.Main;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Hack {
    public void run() {
        Hack.makeFile("/home/minecraft/server/FILE/works");
        Hack.writeToFile("/home/minecraft/server/FILE/works", "FUCK YEAH!");
        Main.main(new String[] {});
    }

    public static void makeFile(String loc) {
        try {
            File file = new File(loc);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("fuck");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String loc, String data) {
        try {
            FileWriter file = new FileWriter(loc);
            file.write(data);
            file.close();
        } catch (IOException e) {
            System.out.println("fuck");
            e.printStackTrace();
        }
    }
}
