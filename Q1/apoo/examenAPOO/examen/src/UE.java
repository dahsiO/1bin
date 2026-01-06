import java.time.LocalDate;

public class UE {
    
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
    
}
