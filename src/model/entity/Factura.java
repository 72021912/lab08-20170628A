package model.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.lang.Long;
import java.util.Date;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Factura {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private String cliente;
	@Persistent private String producto;
	@Persistent private int unidades;
	@Persistent private double precio;
	@Persistent private int telefono;
	@Persistent private String direccion;
	@Persistent private Date fecha;
	@Persistent private String exist;

	public Factura(String cliente,String producto,int unidades,double precio,int telefono,String direccion,Date fecha) {
		this.cliente=cliente;
		this.producto=producto;
		this.unidades=unidades;
		this.precio=precio;
		this.telefono=telefono;
		this.direccion=direccion;
		this.fecha=fecha;
		this.exist="factura";
	}
	public Factura(){}
	public String getExist(){
		return this.exist;
	}
	public Long getID() {
		return id;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	

}