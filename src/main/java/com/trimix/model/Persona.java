package com.trimix.model;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Access(value = AccessType.FIELD)
@Table(name = "personas")
public class Persona {

	private static final long serialVersionUID = -6621618002089338232L;

	@NotNull
	private String perApellido;

	@NotNull
	private Date perFechaNacimiento;

	@Id
	@GeneratedValue
	private Long perId;

	@NotNull
	private String perNombre;

	@NotNull
	private long perNumeroDocumento;

	@NotNull
	private String perTipoDocumento;

	public String getPerApellido() {
		return perApellido;
	}

	public void setPerApellido(String perApellido) {
		this.perApellido = perApellido;
	}

	public Date getPerFechaNacimiento() {
		return perFechaNacimiento;
	}

	public void setPerFechaNacimiento(Date perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}

	public Long getPerId() {
		return perId;
	}

	public void setPerId(Long perId) {
		this.perId = perId;
	}

	public String getPerNombre() {
		return perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public Long getPerNumeroDocumento() {
		return perNumeroDocumento;
	}

	public void setPerNumeroDocumento(Long perNumeroDocumento) {
		this.perNumeroDocumento = perNumeroDocumento;
	}

	public String getPerTipoDocumento() {
		return perTipoDocumento;
	}

	public void setPerTipoDocumento(String perTipoDocumento) {
		this.perTipoDocumento = perTipoDocumento;
	}

	@Override
	public String toString() {
		return "Persona [perApellido=" + perApellido + ", perFechaNacimiento=" + perFechaNacimiento + ", perId=" + perId
				+ ", perNombre=" + perNombre + ", perNumeroDocumento=" + perNumeroDocumento + ", perTipoDocumento="
				+ perTipoDocumento + "]";
	}

}
