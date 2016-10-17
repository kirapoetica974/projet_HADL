package M2.Objet_Architectural.Configuration;

import java.util.ArrayList;
import java.util.List;

import M2.Objet_Architectural.Objet_Architectural;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Configuration extends Objet_Architectural {

	List<Objet_Architectural> listeObjetArchitectural = new ArrayList<Objet_Architectural>();

	List<Lien_Binding> listeLienBinding = new ArrayList<Lien_Binding>();

}
