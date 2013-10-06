package fancyfoods.launcher;

import java.io.PrintStream;

public class WelcomeMessagePrinter {

    void print(PrintStream out) {
        StringBuilder message = new StringBuilder();

        message.append(" ______                       ______              _").append("\n");
        message.append("|  ____|                     |  ____|            | |").append("\n");
        message.append("| |__ __ _ _ __   ___ _   _  | |__ ___   ___   __| |___").append("\n");
        message.append("|  __/ _` | '_ \\ / __| | | | |  __/ _ \\ / _ \\ / _` / __|").append("\n");
        message.append("| | | (_| | | | | (__| |_| | | | | (_) | (_) | (_| \\__ \\").append("\n");
        message.append("|_|  \\__,_|_| |_|\\___|\\__, | |_|  \\___/ \\___/ \\__,_|___/").append("\n");
        message.append("                       __/ |").append("\n");
        message.append("                      |___/").append("\n");

        out.print(message.toString());
    }

}
