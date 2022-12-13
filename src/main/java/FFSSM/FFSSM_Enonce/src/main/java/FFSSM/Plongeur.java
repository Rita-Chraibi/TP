package FFSSM;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Plongeur extends Personne {
    public  int niveau;
    public GroupeSanguin groupSanguin;
    public List<Licence> Licences =new ArrayList<>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, GroupeSanguin groupSanguin,int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.groupSanguin = groupSanguin;
        this.Licences = Licences;
    }
    public Licence getCurrentLicence(LocalDate date){
        Licence currentLicence = null;
        for (Licence l : Licences){
            Period period= Period.between(l.getDelivrance(), date);
            if (period.toTotalMonths()>=0 && period.toTotalMonths()<12){
                return l;
            }
        }
        return currentLicence;
    }
    public void ajouteLicence (String numero, LocalDate delivrance, Club club){
        Licence e = new Licence(this, numero, delivrance, niveau, club);
        Licences.add(e);
    }
}