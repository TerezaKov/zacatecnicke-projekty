package cz.itnetwork;

import java.util.Scanner;

public class VstupyUzivatele {
    private Scanner scanner = new Scanner(System.in, "Windows-1250");

    /**
     * vyžádá od uživatele volbu pro ovládání programu
     */
    public int zadejVolbuProgramu() {
        System.out.println("Zadej volbu:");
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * vyžádá od uživatele zadání jména pojištěného
     */
    public String zadejJmeno() {
        System.out.println("Zadej jméno pojištěného:");
        return scanner.nextLine().trim();
    }

    /**
     * vyžádá od uživatele zadání přijmení pojištěného
     */
    public String zadejPrijmeni() {
        System.out.println("Zadej přijmení pojištěného:");
        return scanner.nextLine().trim();
    }

    /**
     * vyžádá od uživatele zadání věku pojištěného
     */
    public int zadejVek() {
        System.out.println("Zadej věk pojištěného:");
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * vyžádá od uživatele zadání telefonního čísla pojištěného
     */
    public String zadejTelefonniCislo() {
        System.out.println("Zadej telefonní číslo pojištěného (ve formátu 123456789):");
        return scanner.nextLine();
    }

    /**
     * vyžádá od uživatele zadání volby pro vyhledávání pojištěných
     */
    public int zadejVolbuHledani() {
        System.out.println("Zadej volbu:");
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * vyžádá od uživatele zadání id pojištěného
     */
    public int zadejIdPojisteneho() {
        System.out.print("Pojištěný k vymazání: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
