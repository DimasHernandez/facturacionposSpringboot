package co.edu.utp.facturacionposentity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity 
@Table(name = "productos")
public class Productos {
	
	@Id
	@Column(name = "id_producto")
	private int idProducto;
	
	@Column(name = "descripcion")
	private String descripcionProducto;
	
	@Column(name = "cantidad")
	private int cantidadProducto;
	
	@Column(name = "peso")
	private float pesoProducto;
	
	@Column(name = "precio")
	private double precioProducto;
	
	@Column(name = "fecha_ingreso")
	private Date fechaIngresoProducto;
	
	@Column(name = "fecha_vencimiento")
	private Date fechaVencimientoProducto;
	
	//Relacion tabla CategoriaProductos 1 a N
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productos_categoria_id", referencedColumnName = "id")
	private CategoriaProductos categoriaProductos;
	
	//Relacion tabla ProveedorProductos N a N
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(name = "proveedor_productos",
			joinColumns = {@JoinColumn(name = "fk_producto")},
			inverseJoinColumns = {@JoinColumn(name = "fk_proveedor") })
	
	private Set<Proveedor> proveedor = new HashSet<>();
	
	public Productos() {
		
	}
	
	//Encapsular
	
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public float getPesoProducto() {
		return pesoProducto;
	}

	public void setPesoProducto(float pesoProducto) {
		this.pesoProducto = pesoProducto;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public Date getFechaIngresoProducto() {
		return fechaIngresoProducto;
	}

	public void setFechaIngresoProducto(Date fechaIngresoProducto) {
		this.fechaIngresoProducto = fechaIngresoProducto;
	}

	public Date getFechaVencimientoProducto() {
		return fechaVencimientoProducto;
	}

	public void setFechaVencimientoProducto(Date fechaVencimientoProducto) {
		this.fechaVencimientoProducto = fechaVencimientoProducto;
	}

	public CategoriaProductos getProductosCategoria() {
		return categoriaProductos;
	}

	public void setProductosCategoria(CategoriaProductos categoriaProductos) {
		this.categoriaProductos = categoriaProductos;
		categoriaProductos.getProductos().add(this);
	}

	
	public Set<Proveedor> getProveedor() {
		return proveedor;
	}

	public void setProveedor(Set<Proveedor> proveedor) {
		this.proveedor = proveedor;
	}
	
	
	
   

}
