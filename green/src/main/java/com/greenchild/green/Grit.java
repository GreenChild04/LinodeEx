package com.greenchild.green;

import java.util.ArrayList;
import java.util.List;

public class Grit {
    Grit gDefault;
    List<String> keys = new ArrayList<String>();
    List<String> data = new ArrayList<String>();

    public Grit(Grit gDefault) {
        this.gDefault = gDefault;
    }

    public Grit parse(String arg) {
        if (!arg.contains(":")) {
            Green.log("Error: args must contain ':'");
            return this;
        }

        String[] sides = arg.split(":");
        this.set(sides[0], sides[1]);

        return this;
    }

    public String get(String key) {
        if (this.keys.contains(key)) {
            int idx = this.keys.indexOf(key);
            return this.data.get(idx);
        }

        return this.gDefault.get(key);
    }

    public void set(String key, String data) {
        this.keys.add(key);
        this.data.add(data);
    }

    public Grit parseAll(String[] args) {
        for (int i = 0; i < args.length; i++) {
            this.parse(args[i]);
        } return this;
    }
}
