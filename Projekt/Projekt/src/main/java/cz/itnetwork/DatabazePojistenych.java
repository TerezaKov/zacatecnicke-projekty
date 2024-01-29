package cz.itnetwork;

import java.util.LinkedList;
/*
 * Je třeba předělat z důvodu nedodržení SRP a SoC
 * V DatabazePojistenych budou ponechány pouze operace nad seznamem bez vypisování do konzole
 */

/**
 * Databáze pojištěných
 */
public class DatabazePojistenych {
    /**
     * Spojový seznam pojištěných
     */
    private LinkedList<Pojisteny> pojisteni = new LinkedList<>();
    VstupyUzivatele vstupyUzivatele = new VstupyUzivatele();

    /**
     * nabídne menu
     * vyzve k zadání volby programu
     */
    public void Program() {
        int volbaProgramu = 0;
        while (volbaProgramu != 5) {
            vytiskniMenu();
            volbaProgramu = vstupyUzivatele.zadejVolbuProgramu();
            switch (volbaProgramu) {
                case 1:
                    vytvorNovehoPojisteneho();
                    break;
                case 2:
                    ukazVsechnyPojistene();
                    break;
                case 3:
                    if (!pojisteni.isEmpty()) {
                        najdiPojisteneho();
                    } else {
                        System.out.println("\n Databáze je prázdná, prosím přidejte pojištěného \n");
                    }
                    break;
                case 4:
                    if (!pojisteni.isEmpty()) {
                        smazPojisteneho();
                    } else {
                        System.out.println("\n Databáze je prázdná, prosím přidejte pojištěného \n");
                    }
                    break;
                case 5:
                    System.out.println("Ukončuji aplikaci");
                    break;
                default:
                    if (volbaProgramu < 1 || volbaProgramu > 5) {
                        System.out.println("Není vybrána platná volba. Zadejte volbu programu znovu.");
                    }
                    break;
            }
        }
    }

    /**
     * Vytiskne počet pojištěných v databázi
     */
    void vytiskniPocetPojistenych() {
        System.out.println("------------------------------------------");
        System.out.println("Počet pojištěných v databázi: " + pojisteni.size());
        System.out.println("------------------------------------------");
    }

    /**
     * Vypíše nabídku příkazů pro ovládání aplikace
     */
    void vytiskniMenu() {
        System.out.println("__________Evidence pojištěných__________");
        System.out.println("----------------   MENU   ----------------");
        System.out.println("Databáze pojištěných se ovládá následujícími příkazy:");
        System.out.println("- 1 - Přidat nového pojištěného");
        System.out.println("- 2 - Vypsat všechny pojištěné");
        System.out.println("- 3 - Vyhledat pojištěného");
        System.out.println("- 4 - Smazat pojištěného");
        System.out.println("- 5 - Ukončit databázi");
        System.out.println("----------------   MENU   ----------------");
        vytiskniPocetPojistenych();
    }

    /**
     * Vytvoří v databázi nového pojištěného
     */
    void vytvorNovehoPojisteneho() {
        System.out.println("------------------------------------------");
        String jmeno;
        String prijmeni;
        int vek;
        String telefonniCislo;

        boolean jeVeSpravnemFormatu = false;
        /* Kontrolní boolean, který slouží k potvrzení zadání správného formátu vstupu,
         * v případě nesprávného zadání se vypíše varovná zpráva a cyklus while pokračuje,
         * dokud uživatel nezadá správný formát
         */
        while (!jeVeSpravnemFormatu) {
            try {
                jmeno = vstupyUzivatele.zadejJmeno();
                prijmeni = vstupyUzivatele.zadejPrijmeni();
                vek = vstupyUzivatele.zadejVek();
                telefonniCislo = vstupyUzivatele.zadejTelefonniCislo();
                // telefonniCislo.matches("\\d{9}")
                if (jmeno.length() > 2 && jmeno.length() < 15 && jmeno.matches("[\\p{L}]+") && prijmeni.length() > 2 && prijmeni.length() < 25 && prijmeni.matches("[\\p{L}]+") && vek > -1 && vek < 120 && telefonniCislo.matches("\\d{9}")) {
                    pojisteni.add(new Pojisteny(jmeno, prijmeni, vek, telefonniCislo));
                    jeVeSpravnemFormatu = true; // ukončení cyklu
                    Object posledniPojisteny = pojisteni.getLast();
                    System.out.printf("Pojištěný %s byl přidán.", posledniPojisteny);
                } else {
                    System.out.println("Není zadáno ve správném formátu. Jméno musí být dlouhé alespoň 2 a maximálně 15 písmen. Přijmení musí být dlouhé alespoň 2 a maximálně 25 písmen. Jméno a přijmení nesmí obsahovat mezery, číslovky a jiné znaky. Věk zadejte v rozmezí 0 - 120 let číslovkou.");
                }
            } catch (Exception e) {
                System.out.println("Není zadáno ve správném formátu. Věk zadejte v rozmezí 0 - 120 let ČÍSLOVKAMI.");
            }
        }
    }

    /**
     * Vypíše všechny pojištěné v databázi
     */
    void ukazVsechnyPojistene() {
        vytiskniPocetPojistenych();

        System.out.println("------------------------------------------");
        for (int i = 0; i < pojisteni.size(); i++) {
            System.out.println("Pojištený [" + (i + 1) + "]:");
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
        String hledaneJmeno = "";
        String hledanePrijmeni = "";
        int hledanyVek = 0;
        String hledaneTelefonniCislo = "";
        LinkedList<Pojisteny> nalezeniPojisteni = new LinkedList<>();
        System.out.println("Dle jakého kritéria chcete vyhledávat?");
        System.out.println("- 1 - Jméno");
        System.out.println("- 2 - Přijmení");
        System.out.println("- 3 - Věk");
        System.out.println("- 4 - Telefonní číslo");
        int volbaHledani;
        volbaHledani = vstupyUzivatele.zadejVolbuHledani();
        switch (volbaHledani) {
            case 1:
                hledaneJmeno = vstupyUzivatele.zadejJmeno();
                break;
            case 2:
                hledanePrijmeni = vstupyUzivatele.zadejPrijmeni();
                break;
            case 3:
                hledanyVek = vstupyUzivatele.zadejVek();
                break;
            case 4:
                hledaneTelefonniCislo = vstupyUzivatele.zadejTelefonniCislo();
                break;
            default:
                if (volbaHledani < 1 || volbaHledani > 4) {
                    System.out.println("Není vybrána platná volba.");
                }
                break;
        }

        for (Pojisteny pojisteny : pojisteni) {
            if ((pojisteny.getJmeno().equals(hledaneJmeno)) || (pojisteny.getPrijmeni().equals(hledanePrijmeni)) || (pojisteny.getVek() == hledanyVek) || (pojisteny.getTelefonniCislo().equals(hledaneTelefonniCislo))) {
                nalezeniPojisteni.add(pojisteny);
            }
        }
        if (!nalezeniPojisteni.isEmpty()) {
            System.out.println(nalezeniPojisteni);
        } else {
            System.out.println("Pojištěný nebyl nalezen.");
        }
        return nalezeniPojisteni;
    }

    /**
     * Smaže pojištěného z databáze
     * ověří, zda je vstup správně zadaný
     */
    void smazPojisteneho() {

        ukazVsechnyPojistene();

        boolean jeSpravne = false;
        /* Kontrolní boolean, který slouží k potvrzení zadání správného vstupu,
         * v případě nesprávného zadání se vypíše varovná zpráva a cyklus while pokračuje,
         * dokud uživatel nezadá platný index
         */
        while (!jeSpravne) {
            try {
                System.out.println("Jakého pojištěného si přejete vymazat?");
                System.out.println("- pro vymazání pojištěného zadejte index pojištěného, například => 1");
                int id = vstupyUzivatele.zadejIdPojisteneho();
                int idOJednaMensi = id - 1;
                pojisteni.remove(idOJednaMensi);
                System.out.println("Pojištěný byl smazán.");
                jeSpravne = true; // ukončení cyklu
            } catch (Exception e) {
                System.out.println("Zadaná hodnota neodpovídá indexu žádného z pojištěných.");
            }
        }
    }
}

