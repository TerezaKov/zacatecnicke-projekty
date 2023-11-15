package cz.itnetwork;

public class Aplikace {
        public static void main(String[] args) {
            VstupyUzivatele uzivatelskyVstup = new VstupyUzivatele();
            DatabazePojistenych spravceDat = new DatabazePojistenych(uzivatelskyVstup);
        UzivatelskeRozhrani uzivatelskeRozhrani = new UzivatelskeRozhrani(spravceDat, new VstupyUzivatele());
        uzivatelskeRozhrani.spustitAplikaci();
    }
}