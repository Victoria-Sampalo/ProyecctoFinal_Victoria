package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name="persona")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idpersona;

	private String apelpersona;

	private String dirUsuario;

	private String dni;

	@Temporal(TemporalType.DATE)
	private Date fecnacim;

	private String nombreperson;

	private String sexo;

	//bi-directional one-to-one association to Tarjetasanitaria
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="numtarjeta")
	private Tarjetasanitaria tarjetasanitaria;

	//bi-directional many-to-one association to Hospital
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codhospi", referencedColumnName="codhospi")
	private Hospital hospital;

	public Persona() {
	}

	public long getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}

	public String getApelpersona() {
		return this.apelpersona;
	}

	public void setApelpersona(String apelpersona) {
		this.apelpersona = apelpersona;
	}

	public String getDirUsuario() {
		return this.dirUsuario;
	}

	public void setDirUsuario(String dirUsuario) {
		this.dirUsuario = dirUsuario;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFecnacim() {
		return this.fecnacim;
	}

	public void setFecnacim(Date fecnacim) {
		this.fecnacim = fecnacim;
	}

	public String getNombreperson() {
		return this.nombreperson;
	}

	public void setNombreperson(String nombreperson) {
		this.nombreperson = nombreperson;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Tarjetasanitaria getTarjetasanitaria() {
		return this.tarjetasanitaria;
	}

	public void setTarjetasanitaria(Tarjetasanitaria tarjetasanitaria) {
		this.tarjetasanitaria = tarjetasanitaria;
	}

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	//source >tostring >stringBuilder
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona [idpersona=");
		builder.append(idpersona);
		builder.append(", apelpersona=");
		builder.append(apelpersona);
		builder.append(", dirUsuario=");
		builder.append(dirUsuario);
		builder.append(", dni=");
		builder.append(dni);
		builder.append(", fecnacim=");
		builder.append(fecnacim);
		builder.append(", nombreperson=");
		builder.append(nombreperson);
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append(", tarjetasanitaria=");
		builder.append(tarjetasanitaria);
		builder.append(", hospital=");
		builder.append(hospital);
		builder.append("]");
		return builder.toString();
	}

	
	

}