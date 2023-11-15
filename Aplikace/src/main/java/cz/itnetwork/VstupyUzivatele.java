package cz.itnetwork;

import java.util.Scanner;

public class VstupyUzivatele {
    private Scanner scanner = new Scanner(System.in);

    public String getZadatText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getZadatCislo(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }
}

