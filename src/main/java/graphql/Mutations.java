package graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import entities.Etudiant;
import entities.Option;
import repository.EtudiantBusiness;
import repository.OptionBusiness;

public class Mutations implements GraphQLMutationResolver {
    private OptionBusiness optionBusiness;
    private EtudiantBusiness etudiantBusiness;

    public Mutations(OptionBusiness optionBusiness, EtudiantBusiness etudiantBusiness) {
        this.optionBusiness = optionBusiness;
        this.etudiantBusiness = etudiantBusiness;
    }

    public boolean addOption(int codeOption, String libelle, String domaine, String responsable, int credits, int semestre, int capacite) {
        return optionBusiness.addOption(new Option(codeOption, libelle, domaine, responsable, credits, semestre, capacite));
    }

    public boolean updateOption(int codeOption, String libelle, String domaine, String responsable, int credits, int semestre, int capacite) {
        return optionBusiness.updateOption(codeOption, new Option(codeOption, libelle, domaine, responsable, credits, semestre, capacite));
    }

    public boolean deleteOption(int codeOption) { return optionBusiness.deleteOption(codeOption); }

    public boolean addEtudiant(String identifiant, String nom, String prenom, int anneeEtude, String email, int codeOption) {
        Option option = optionBusiness.getOptionByCode(codeOption);
        return etudiantBusiness.addEtudiant(new Etudiant(identifiant, nom, prenom, option, anneeEtude, email));
    }

    public boolean updateEtudiant(String identifiant, String nom, String prenom, int anneeEtude, String email, int codeOption) {
        Option option = optionBusiness.getOptionByCode(codeOption);
        return etudiantBusiness.updateEtudiant(identifiant, new Etudiant(identifiant, nom, prenom, option, anneeEtude, email));
    }

    public boolean deleteEtudiant(String identifiant) { return etudiantBusiness.deleteEtudiant(identifiant); }
}