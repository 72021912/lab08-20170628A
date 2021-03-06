package model.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.lang.Long;
import java.util.Date;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Role {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private String Nombre;
	@Persistent private boolean status ;
	@Persistent private String exist;
	@Persistent private Date fecha;

	public Role(String Nombre,boolean status,Date fecha) {
		this.Nombre=Nombre;
		this.status=status;
		this.exist="role";
		this.fecha=fecha;
	}
	public Role(){}
	public String getExist(){
		return this.exist;
	}
	public Long getID() {
		return id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String Nombre) {
		this.Nombre=Nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean getStatus(){
		return status;
	}
	public void setStatus(boolean status){
		this.status=status;
	}

}