package cz.itnetwork;

public class UzivatelskeRozhrani {
    private DatabazePojistenych spravceDat;
    private VstupyUzivatele uzivatelskyVstup;

    public UzivatelskeRozhrani(DatabazePojistenych spravceDat, VstupyUzivatele uzivatelskyVstup) {
        this.spravceDat = spravceDat;
        this.uzivatelskyVstup = uzivatelskyVstup;
    }

    public void spustitAplikaci() {
        int volba = 0;
        while (volba != 5) {
            spravceDat.vytisknoutMenu();
            volba = Integer.parseInt(uzivatelskyVstup.getZadatText("Zadejte příkaz: "));
            switch (volba) {
                case 1:
                    spravceDat.vytvoritNovehoPojisteneho(uzivatelskyVstup);
                    break;

                case 2:
                    spravceDat.ukazatVsechnyPojistene();
                    break;

                case 3:
                    spravceDat.najitPojisteneho();
                    break;

                case 4:
                    if (!spravceDat.ziskatVsechnyPojistene().isEmpty()) {
                        spravceDat.smazatPojisteneho();
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
}

