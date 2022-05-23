package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hospital database table.
 * 
 */
@Entity
@Table(name= "hospital")
@NamedQuery(name="Hospital.findAll", query="SELECT h FROM Hospital h")
public class Hospital implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codhospi;

	private String cifhospi;

	private String codpostal;

	private String dirhospi;

	private String nomhospi;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="hospital")
	private List<Persona> personas;

	public Hospital() {
	}

	public String getCifhospi() {
		return this.cifhospi;
	}

	public void setCifhospi(String cifhospi) {
		this.cifhospi = cifhospi;
	}

	public String getCodpostal() {
		return this.codpostal;
	}

	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}

	public String getDirhospi() {
		return this.dirhospi;
	}

	public void setDirhospi(String dirhospi) {
		this.dirhospi = dirhospi;
	}

	public String getNomhospi() {
		return this.nomhospi;
	}

	public void setNomhospi(String nomhospi) {
		this.nomhospi = nomhospi;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setHospital(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setHospital(null);

		return persona;
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hospital [codhospi=");
		builder.append(codhospi);
		builder.append(", cifhospi=");
		builder.append(cifhospi);
		builder.append(", codpostal=");
		builder.append(codpostal);
		builder.append(", dirhospi=");
		builder.append(dirhospi);
		builder.append(", nomhospi=");
		builder.append(nomhospi);
		builder.append(", personas=");
		builder.append(personas);
		builder.append("]");
		return builder.toString();
	}
	
	

}