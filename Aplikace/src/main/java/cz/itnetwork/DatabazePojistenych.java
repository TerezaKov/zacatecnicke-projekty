package cz.itnetwork;

import java.util.LinkedList;
import java.util.Scanner;

public class DatabazePojistenych {
    Scanner scanner = new Scanner(System.in);
    private LinkedList<Pojisteny> pojisteni = new LinkedList<>();
    private VstupyUzivatele uzivatelskyVstup;
    public DatabazePojistenych(VstupyUzivatele uzivatelskyVstup) {
        this.uzivatelskyVstup = uzivatelskyVstup;
    }

    public void pridatPojisteneho(Pojisteny pojisteny) {
        pojisteni.add(pojisteny);
    }

    public LinkedList<Pojisteny> ziskatVsechnyPojistene() {
        return pojisteni;
    }

    void vytisknoutPocetPojistenych() {
        System.out.println("------------------------------------------");
        System.out.println("Počet pojištěných v databázi: " + pojisteni.size());
        System.out.println("------------------------------------------");
    }

    void vytisknoutMenu() {
        // Vaše původní metoda VytiskniMenu() byla přejmenována na vytisknoutMenu()
        System.out.println("_________Evidence pojištěných_________");
        System.out.println("----------------   MENU   ----------------");
        System.out.println("Databáze pojištěnců se ovládá následujícími příkazy:");
        System.out.println("- 1 - Přidat nového pojištěného");
        System.out.println("- 2 - Vypsat všechny pojištěné");
        System.out.println("- 3 - Vyhledat pojištěného");
        System.out.println("- 4 - Smazat pojištěného");
        System.out.println("- 5 - Ukončit databázi");
        System.out.println("----------------   MENU   ----------------");
        vytisknoutPocetPojistenych();
    }

    void vytvoritNovehoPojisteneho(VstupyUzivatele uzivatelskyVstup) {
        System.out.println("------------------------------------------");
        String jmeno = uzivatelskyVstup.getZadatText("Zadejte jméno pojištěného:");
        String prijmeni = uzivatelskyVstup.getZadatText("Zadejte přijmení pojištěného:");
        int vek = uzivatelskyVstup.getZadatCislo("Zadejte věk pojištěného:");
        String cislo = uzivatelskyVstup.getZadatText("Zadejte telefonní číslo pojištěného");

        Pojisteny pojisteny = new Pojisteny(jmeno, prijmeni, vek, cislo);
        pridatPojisteneho(pojisteny);

        System.out.println("Pojistěný byl přidán");
        System.out.println("------------------------------------------");
    }

    void ukazatVsechnyPojistene() {
        vytisknoutPocetPojistenych();

        System.out.println("------------------------------------------");
        LinkedList<Pojisteny> vsechnyPojistene = ziskatVsechnyPojistene();
        for (int i = 0; i < vsechnyPojistene.size(); i++) {
            System.out.println("Pojištený [" + (i + 1) + "] vytvořen:");
            System.out.println(vsechnyPojistene.get(i) + "\n");
        }
        System.out.println("------------------------------------------");
    }

    public LinkedList<Pojisteny> najitPojisteneho() {
        // Vaše původní metoda najdiPojisteneho() byla přejmenována na najitPojisteneho()
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
                hledaneJmeno = uzivatelskyVstup.getZadatText("Zadejte jméno pojištěného:");
                break;
            case 2:
                hledanePrijmeni = uzivatelskyVstup.getZadatText("Zadejte přijmení pojištěného:");
                break;
            case 3:
                hledanyVek = uzivatelskyVstup.getZadatCislo("Zadejte věk pojištěného:");
                break;
            case 4:
                hledaneCislo = uzivatelskyVstup.getZadatText("Zadejte telefonní číslo pojištěného:");
                break;
        }

        for (Pojisteny pojisteny : ziskatVsechnyPojistene()) {
            if ((pojisteny.getJmeno().equals(hledaneJmeno)) || (pojisteny.getPrijmeni().equals(hledanePrijmeni)) || (pojisteny.getVek() == hledanyVek) || (pojisteny.getCislo().equals(hledaneCislo))) {
                nalezeniPojisteni.add(pojisteny);
            } if(nalezeniPojisteni.isEmpty()) {
                System.out.println("Pojištěný nebyl nalezen v databázi");
            } else {
                System.out.println(nalezeniPojisteni);
            }
        }
        return nalezeniPojisteni;
    }

    void smazatPojisteneho() {
        ukazatVsechnyPojistene();

        boolean jeSpravne = false;
        while (!jeSpravne) {
            try {
                System.out.println("Jakého pojištěného si přejete vymazat?");
                System.out.println("- pro vymazání pojištěného zadejte index pojištěného, například => 1");
                System.out.print("Pojištěný k vymazání: ");
                int id = Integer.parseInt(scanner.nextLine());
                int idOJednaMensi = id - 1;
                ziskatVsechnyPojistene().remove(idOJednaMensi);
                jeSpravne = true;
            } catch (Exception e) {
                System.out.println(
                        "Zadaná hodnota neodpovídá indexu žádného z pojištěných.");
            }
        }
    }
}
