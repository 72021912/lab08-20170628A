package model.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.lang.Long;
import java.util.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Access	 {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private Long role;
	@Persistent private Long resource;
	@Persistent private boolean status ;
	@Persistent private String exist;
	@Persistent private Date fecha;

	public Access(Long role,Long resource,boolean status,Date fecha) {
		this.role=role;
		this.resource=resource;
		this.status=status;
		this.exist="access";
		this.fecha=fecha;
	}
	public Access(){}
	public String getExist(){
		return this.exist;
	}
	public Long getID() {
		return id;
	}
	public Long getRol() {
		return role;
	}
	public void setRol(Long Role) {
		this.role=Role;
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
	public void setResource(Long resource){
		this.resource=resource;
	}
	public Long getResource(){
		return this.resource;
	}

}