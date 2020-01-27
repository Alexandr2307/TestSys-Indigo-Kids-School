package view;

import view.frames.Window;

public class Main {
    public static void main(String[] args) {
        new Window(args[0], args[1]).setVisible(true);
    }
}
