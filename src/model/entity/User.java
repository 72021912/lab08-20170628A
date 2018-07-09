package model.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.lang.Long;
import java.util.Date;
import java.util.GregorianCalendar;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class User {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private String nombre;
	@Persistent private String apellido;
	@Persistent private String correo;
	@Persistent private Long role;
	@Persistent private Date cumpleaños;
	@Persistent private String genero ;
	@Persistent private boolean status;
	@Persistent private Date fecha;
	@Persistent private String exist;

	public User(String nombre,String apellido,String correo, Long role, Date cumpleaños,String genero,boolean status,Date fecha) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.correo=correo;
		this.role=role;
		this.cumpleaños=cumpleaños;
		this.genero=genero;
		this.exist="user";
		this.fecha=fecha;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public User(){}
	public String getExist(){
		return this.exist;
	}
	public Long getID() {
		return id;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Long getRole() {
		return role;
	}
	public void setRole(Long role) {
		this.role = role;
	}
	public Date getCumpleaños() {
		return cumpleaños;
	}
	public void setCumpleaños(Date cumpleaños) {
		this.cumpleaños = cumpleaños;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha=fecha;
	}
}
