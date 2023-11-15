package cz.itnetwork;

import java.util.LinkedList;
import java.util.Scanner;

public class DatabazePojistenych {
    /**
     * Spojový seznam pojištěných
     */
    private LinkedList<Pojisteny> pojisteni = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    /**
     * nabídne menu
     * vyžádá příkaz
     */
    public void Program() {
        int volba = 0;
        while (volba != 5) {
            VytiskniMenu();
            volba = Integer.parseInt(scanner.nextLine());
            switch (volba) {
                case 1:
                    VytvorNovehoPojisteneho();
                    break;

                case 2:
                    UkazVsechnyPojistene();
                    break;

                case 3:
                    najdiPojisteneho();
                    break;

                case 4:
                    if (!pojisteni.isEmpty()) {
                        SmazPojisteneho();
                    } else {
                        System.out.println("\n Databáze je prázdná, prosím přidejte pojištěného \n");
                    }
                    break;

                case 5:
                    System.out.println("Ukončuji aplikaci");
                    break;
            }
        }

    }

    /**
     * Vytiskne počet pojištěnců v databázi
     */
    void VytiskniPocetPojistenych() {
        System.out.println("------------------------------------------");
        System.out.println("Počet pojištěných v databázi: " + pojisteni.size());
        System.out.println("------------------------------------------");
    }

    /**
     * Vypíše nabídku příkazů pro ovládání aplikace
     */
    void VytiskniMenu() {
        System.out.println("__________Evidence pojištěných__________");
        System.out.println("----------------   MENU   ----------------");
        System.out.println("Databáze pojištěnců se ovládá následujícími příkazy:");
        System.out.println("- 1 - Přidat nového pojištěného");
        System.out.println("- 2 - Vypsat všechny pojištěné");
        System.out.println("- 3 - Vyhledat pojištěného");
        System.out.println("- 4 - Smazat pojištěného");
        System.out.println("- 5 - Ukončit databázi");
        System.out.println("----------------   MENU   ----------------");
        VytiskniPocetPojistenych();
        System.out.println("Zadejte příkaz: ");
    }

    /**
     * Vytvoří v databázi nového pojištěnce
     */
    void VytvorNovehoPojisteneho() {
        System.out.println("------------------------------------------");
        String jmeno;
        String prijmeni;
        int vek;
        String cislo;
        System.out.print("Zadejte jméno pojištěného:");
        jmeno = scanner.nextLine();
        System.out.print("Zadejte přijmení pojištěného:");
        prijmeni = scanner.nextLine();
        System.out.print("Zadejte věk pojištěnce:");
        vek = Integer.parseInt(scanner.nextLine());
        System.out.print("Zadejte telefonní číslo pojištěného");
        cislo = scanner.nextLine();
        pojisteni.add(new Pojisteny(jmeno, prijmeni, vek, cislo));



        System.out.println("Pojistěný byl přidán");
        System.out.println("------------------------------------------");
    }

    /**
     * Vypíše všechny pojištěnce v databázi
     */
    void UkazVsechnyPojistene() {
        VytiskniPocetPojistenych();

        System.out.println("------------------------------------------");
        for (int i = 0; i < pojisteni.size(); i++) {
            System.out.println("Pojištený [" + (i + 1) + "] vytvořen:");
            System.out.println(pojisteni.get(i) + "\n");

        }
        System.out.println("------------------------------------------");
    }


    /**
     * Najde pojišteného dle jména, přijmení, věku a čísla
     *
     * @return Kolekce nalezených pojištěných
     */
    public LinkedList<Pojisteny> najdiPojisteneho() {
        LinkedList<Pojisteny> nalezeniPojisteni = new LinkedList<>();
        String hledaneJmeno = "";
        String hledanePrijmeni = "";
        int hledanyVek = 0;
        String hledaneCislo = "";
        System.out.println("Dle jakého kritéria chcete vyhledávat?");
        System.out.println("- 1 - Jméno");
        System.out.println("- 2 - Přijmení");
        System.out.println("- 3 - Věk");
        System.out.println("- 4 - Číslo");
        System.out.println("Zadejte příkaz: ");
        int volbaHledani;
        volbaHledani = Integer.parseInt(scanner.nextLine());
        switch (volbaHledani) {
            case 1:
                System.out.print("Zadejte jméno pojištěného:");
                hledaneJmeno = scanner.nextLine();
                break;

            case 2:
                System.out.print("Zadejte přijmení pojištěného:");
                hledanePrijmeni = scanner.nextLine();
                break;

            case 3:
                System.out.print("Zadejte věk pojištěného:");
                hledanyVek = Integer.parseInt(scanner.nextLine());
                break;

            case 4:
                System.out.print("Zadejte telefonní číslo pojištěného:");
                hledaneCislo = scanner.nextLine();
                break;
        }

        for (Pojisteny pojisteny : pojisteni) {
            if ((pojisteny.getJmeno().equals(hledaneJmeno)) || (pojisteny.getPrijmeni().equals(hledanePrijmeni)) || (pojisteny.getVek() == hledanyVek) || (pojisteny.getCislo().equals(hledaneCislo))) {
                nalezeniPojisteni.add(pojisteny);
            } else {
                System.out.println("Pojištěný nebyl nalezen v databázi");
            }
        }
        System.out.println(nalezeniPojisteni);
        return nalezeniPojisteni;
    }

    /**
     * Smaže pojištěnce z databáze
     */
    void SmazPojisteneho() {

        UkazVsechnyPojistene();

        boolean jeSpravne = false;
        /* Kontrolní boolean, který slouží k potvrzení zadání správného vstupu,
         * v případě nesprávného zadání se vypíše varovná zpráva a cyklus while pokračuje,
         * dokud uživatel nezadá platný index
         */
        while (!jeSpravne) {
            try {
                System.out.println("Jakého pojištěného si přejete vymazat?");
                System.out.println("- pro vymazání pojištěného zadejte index pojištěného, například => 1");
                System.out.print("Pojištěný k vymazání: ");
                int id = Integer.parseInt(scanner.nextLine());
                int idOJednaMensi = id - 1;
                pojisteni.remove(idOJednaMensi); // Vymazání záznamu
                jeSpravne = true; // Nastavení booleanu jeSpravne na true, které ukončí cyklus while

            } catch (Exception e) {
                System.out.println(
                        "Zadaná hodnota neodpovídá indexu žádného z pojištěných.");
            }
        }
    }
}
