package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tarjetasanitaria database table.
 * 
 */
@Entity
@Table(name="tarjetaSanitaria")
@NamedQuery(name="Tarjetasanitaria.findAll", query="SELECT t FROM Tarjetasanitaria t")
public class Tarjetasanitaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String numtarjeta;

	@Temporal(TemporalType.DATE)
	private Date feccaduca;

	//bi-directional one-to-one association to Persona
	@OneToOne(mappedBy="tarjetasanitaria", fetch=FetchType.LAZY)
	private Persona persona;
	//veo que tarjetasanitaria tiene una persona 

	public Tarjetasanitaria() {
	}

	public String getNumtarjeta() {
		return this.numtarjeta;
	}

	public void setNumtarjeta(String numtarjeta) {
		this.numtarjeta = numtarjeta;
	}

	public Date getFeccaduca() {
		return this.feccaduca;
	}

	public void setFeccaduca(Date feccaduca) {
		this.feccaduca = feccaduca;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		/*Para evitar sucesivas llamada concatenadas entre objetos relacionados
		 * vamos a usar el atributo del nombre del paciente, no el tostring completo.
		 * Comento en el tostring dicho atributo*/
		String nombrePaciente = (this.persona != null) ? this.persona.getNombreperson() : ""; 
		StringBuilder builder = new StringBuilder();
		builder.append("Tarjetasanitaria [numtarjeta=");
		builder.append(numtarjeta);
		builder.append(", feccaduca=");
		builder.append(feccaduca);
		/* Para evitar stackoverflow añadimos el nombre de la persona arriba
		builder.append(", persona=");
		builder.append(persona);*/
		builder.append("]");
		return builder.toString();
	}
	

}