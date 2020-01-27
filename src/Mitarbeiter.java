public class Mitarbeiter {

    private String vorname, nachname = new String();

    private int personalnummer;

    private double arbeitszeit, gehalt;

    private Mitarbeiter(String vorname, String nachname, int personalnummer, double gehalt) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.personalnummer = personalnummer;
        this.gehalt = gehalt;
        System.out.println("* Neuer Mitarbeiter angelegt *");
        System.out.println("Mitarbeiter: " + this.vorname + " " + this.nachname);
        System.out.println("Personalnummer: " + this.personalnummer);
        System.out.println("Stundenlohn: " + this.gehalt + "€\n");
    }

    private void setzeArbeitszeit(double zeit) {
        this.arbeitszeit = zeit;
        System.out.println("Erfasste Arbeitszeit: " + this.arbeitszeit + " Stunden");
        berechneGehalt(zeit);
    }

    private void berechneGehalt(double stunden) {
        double gehalt;
        // TODO
        if(stunden >= 160) {
            if(160 <= stunden && stunden <= 180) {
                gehalt = this.gehalt * 160 + this.gehalt * (stunden - 160) * 1.1;
            } else {
                gehalt = this.gehalt * 160 + this.gehalt * (stunden - 160) * 1.1 + this.gehalt * ((stunden - 180) * 1.1) * 1.05;
            }
        } else {
            gehalt = this.gehalt * stunden;
        }
        System.out.println("Entgeld: " + Math.round(100.0 * gehalt) / 100.0 + "€");
    }

    private void lohnAenderungen(double prozent) {
        this.gehalt *= (100 + prozent) / 100;
        System.out.println("\nStundenlohn wurde um " + prozent + "% geändert\n");
    }

    public static void main(String[] main) {
        Mitarbeiter leo_lustig = new Mitarbeiter("Leo", "Lustig", 11, 17.50);

        leo_lustig.setzeArbeitszeit(149);

        leo_lustig.lohnAenderungen(2.5);

        leo_lustig.setzeArbeitszeit(200);
    }

}
