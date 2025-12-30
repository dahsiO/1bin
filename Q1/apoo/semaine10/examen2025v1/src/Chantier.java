import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Chantier {
    
    private int numero ;
    private String nom ;
    private String adresse ;
    private Salarie chef ;
	// TODO
    private LocalDateTime dateDeFin;
    private static int nombreDeChantiers = 0;

    public Chantier(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.chef = null;
        this.dateDeFin = null;
        this.numero = nombreDeChantiers++;
        //TODO
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }
	
	public String getAdresse(){
		return adresse;
	}

    public Salarie getChef() {
        return chef;
    }
    //est terminer
    public boolean estTerminee(){
        if (dateDeFin != null){
            return true;
        }
        return false;

    }
    public boolean assigneeChef(Salarie nouveauChef){
        if (this.estTerminee())return false;

        if (nouveauChef.getChantierActuel() != this){
            this.chef = nouveauChef;
        }
        return true;
    }
    public boolean Terminee() {
        if (this.estTerminee()) {
            return false;
        } else dateDeFin = LocalDateTime.now();

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chantier chantier = (Chantier) o;
        return numero == chantier.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }

    @Override
    public String toString() {
        String chantier = "Chantier n°"+numero+" : "+nom+" situé "+adresse+'\n'+"Statut : ";
        if (!estTerminee()) {
            chantier += "en cours";
        } else {
            chantier += "terminé le "+dateDeFin;
        }
        chantier += '\n'+"Chef de chantier : " ;
        if (this.chef == null) {
            chantier += "pas encore choisi";
        } else {
            chantier += chef.getNom()+" "+chef.getPrenom();
        }
        return chantier ;
    }

    
}