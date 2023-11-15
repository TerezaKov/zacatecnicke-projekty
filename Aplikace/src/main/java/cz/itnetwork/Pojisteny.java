package cz.itnetwork;

public class Pojisteny {
    /**
     * Jméno
     */
    private String jmeno;
    /**
     * Přijmení
     */
    private String prijmeni;
    /**
     * věk
     */
    private int vek;
    /**
     * telefonní číslo
     */
    private String cislo; //dát na private a vytvořit getter // pokud bych upravovala nastavím setter

    /**
     * Inicializuje instanci
     *
     * @param jmeno    Jméno
     * @param prijmeni Příjmení
     * @param vek      Věk
     * @param cislo    Číslo
     */
    public Pojisteny(String jmeno, String prijmeni, int vek, String cislo) {
        setJmeno(jmeno);
        setPrijmeni(prijmeni);
        setVek(vek);
        setCislo(cislo);
    }

    public String getJmeno() {
        return jmeno;
    }
    public String getPrijmeni() {
        return prijmeni;
    }
    public int getVek() {
        return vek;
    }
    public String getCislo() {
        return cislo;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }
    public void setVek(int vek) {
        this.vek = vek;
    }
    public void setCislo(String cislo) {
        this.cislo = cislo;
    }
    /**
     * Pojištěný zformátovaný
     * Vypíše ve tvaru jméno přijmení věk   číslo
     */
    @Override
    public String toString() {
        return jmeno + " " + prijmeni + " " + vek + "   " + cislo;
    }
}
