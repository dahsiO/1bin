import java.time.LocalDate;
import java.util.Objects;

public class UE {

    private static final String[] CURSUS_EXISTANTS ={"BIN","BIM","BCH","BBQ"};
    private String code ;
    private String nom ;
    private Professeur responsable ;
	private String cursus ;
    private LocalDate dateCreation ;
    private int nbrDeProfesseurs ;
	//TODO

    public UE(String code, String nom, String cursus) {
		// TODO
        this.code = code;
        this.nom = nom;
        this.responsable = null;
        this.nbrDeProfesseurs = 0;
        // Vérification si le cursus existe
        boolean cursusValide = false;
        for (String cursusExistant : CURSUS_EXISTANTS) {
            if (cursusExistant.equals(cursus)) {
                cursusValide = true;
                break;
            }
        }

        if (!cursusValide) {
            throw new IllegalArgumentException(cursus + " n'est pas un cursus valide");
        }else {
            this.cursus = cursus;
        }
        this.dateCreation = LocalDate.now();


    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public Professeur getResponsable() {
        return responsable;
    }
	
	public String getCursus() {
        return cursus;
    }
	
	public LocalDate getDateCreation() {
        return dateCreation;
    }

    public int getNbrDeProfesseurs() {
        return nbrDeProfesseurs;
    }

	public void incrementerNbrDeProfesseurs() {
        this.nbrDeProfesseurs++;
    }

    public void decrementerNbrDeProfesseurs() {
        this.nbrDeProfesseurs--;
    }
    //assigner responsable
    public boolean assignerResponsable(Professeur responsable){
        if (!responsable.intervientDans(this)) {//utiliser une methode de professeur
            return false;
        }
        this.responsable = responsable;
        return true;
    }

    //hashcode equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UE ue = (UE) o;
        return Objects.equals(code, ue.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
    //toString
    @Override
    public String toString() {
        String ue = code+" : "+nom+" du cursus "+cursus+" créée le "+dateCreation ; ;
        ue += '\n'+"Responsable : " ;
        if (responsable == null) {
            ue += "pas encore choisi";
        } else {
            ue += responsable.getNom()+" "+responsable.getPrenom();
        }
        ue += "\n" + "Nombre de professeurs intervenants : "+nbrDeProfesseurs ;
        return ue ;
    }
    
}
