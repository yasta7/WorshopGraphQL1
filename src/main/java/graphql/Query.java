package graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import entities.Etudiant;
import entities.Option;
import repository.EtudiantBusiness;
import repository.OptionBusiness;
import java.util.List;

public class Query implements GraphQLQueryResolver {
    private OptionBusiness optionBusiness;
    private EtudiantBusiness etudiantBusiness;

    public Query(OptionBusiness optionBusiness, EtudiantBusiness etudiantBusiness) {
        this.optionBusiness = optionBusiness;
        this.etudiantBusiness = etudiantBusiness;
    }

    public List<Option> getAllOptions() { return optionBusiness.getListeOptions(); }
    public List<Option> getOptionsByDomaine(String domaine) { return optionBusiness.getOptionsByDomaine(domaine); }
    public Option getOptionByCode(int codeOption) { return optionBusiness.getOptionByCode(codeOption); }

    public List<Etudiant> getAllEtudiants() { return etudiantBusiness.getAllEtudiants(); }
    public Etudiant getEtudiantById(String identifiant) { return etudiantBusiness.getEtudiantByIdentifiant(identifiant); }
    public List<Etudiant> getEtudiantsByOption(int codeOption) {
        Option option = optionBusiness.getOptionByCode(codeOption);
        return (option != null) ? etudiantBusiness.getEtudiantsByOption(option) : null;
    }
}