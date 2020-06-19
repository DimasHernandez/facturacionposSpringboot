package co.edu.utp.facturacionposentity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "Proveedor")
@Table(name = "proveedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProvedor;
	
	@Column(name = "nombre_proveedor")
	private String nombreProveedor;
	
	///Relacion tabla Productos N a N
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "proveedor"
			)
	
	private Set<Productos> productos = new HashSet<>();
	
	public Proveedor() {
		
	}
	

	public int getIdProvedor() {
		return idProvedor;
	}

	public void setIdProvedor(int idProvedor) {
		this.idProvedor = idProvedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}


	public Set<Productos> getProductos() {
		return productos;
	}


	public void setProductos(Set<Productos> productos) {
		this.productos = productos;
	}
	
	
	
	

}
