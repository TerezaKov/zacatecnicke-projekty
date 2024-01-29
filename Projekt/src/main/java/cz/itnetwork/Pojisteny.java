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
     * Věk
     */
    private int vek;
    /**
     * Telefonní číslo
     */
    private String telefonniCislo;

    /**
     * Inicializuje instanci Pojištěného
     *
     * @param jmeno          Jméno
     * @param prijmeni       Příjmení
     * @param vek            Věk
     * @param telefonniCislo Telefonní číslo
     */
    public Pojisteny(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        setJmeno(jmeno);
        setPrijmeni(prijmeni);
        setVek(vek);
        setTelefonniCislo(telefonniCislo);
    }

    /**
     * vrací jméno pojištěného
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * vrací přijmení pojištěného
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * vrací věk pojištěného
     */
    public int getVek() {
        return vek;
    }

    /**
     * vrací telefonní číslo pojištěného
     */
    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    /**
     * nastaví jméno pojištěného
     */

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * nastaví přijmení pojištěného
     */
    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    /**
     * nastaví věk pojištěného
     */
    public void setVek(int vek) {
        this.vek = vek;
    }

    /**
     * nastaví telefonní číslo pojištěného
     */
    public void setTelefonniCislo(String telefonniCislo) {
        this.telefonniCislo = telefonniCislo;
    }

    /**
     * Pojištěný zformátovaný
     * Vypíše ve tvaru jméno    přijmení    věk     telefonní číslo
     */
    @Override
    public String toString() {
        return jmeno + "    " + prijmeni + "    " + vek + "     " + telefonniCislo;
    }
}

