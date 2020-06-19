package co.edu.utp.facturacionposentity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "ProductosCategoria")
@Table(name = "productos_categoria")

public class CategoriaProductos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre_categoria")
	private String nombreCategoria;
	
	//Relacion entre las tablas Productos categoria y Productos
	
	@OneToMany(
			mappedBy = "productosCategoria",
			cascade = CascadeType.PERSIST,
			fetch = FetchType.LAZY			
	)
	
	private Set<Productos> productos;
	
	public CategoriaProductos() {
		productos = new HashSet<>();
	}
	
	public CategoriaProductos(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
		productos = new HashSet<>();
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Set<Productos> getProductos() {
		return productos;
	}

	public void setProductos(Set<Productos> productos) {
		this.productos = productos;
		for (Productos producto : productos) {
			producto.setProductosCategoria(this);
		}
	}
	
	
	
	

}
