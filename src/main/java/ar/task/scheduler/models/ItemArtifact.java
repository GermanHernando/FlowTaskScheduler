package ar.task.scheduler.models;

import ar.task.scheduler.models.validators.ItemArtifactValidator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;

@MappedSuperclass
public abstract class ItemArtifact extends Persistible {

	@Column(name = "TITULO")
	private String titulo;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CATEGORIA_ID")
	private Categoria categoria;

	ItemArtifact() {}
	
	public ItemArtifact(String titulo, String descripcion, Categoria categoria) {
		this.setTitulo(titulo);
		this.setDescripcion(descripcion);
		this.setCategoria(categoria);
	}
	
	
	public void setTitulo(String titulo) {
		this.titulo = ItemArtifactValidator.tituloValidator(titulo);
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = ItemArtifactValidator.descripcionValidator(descripcion);
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = ItemArtifactValidator.categoriaValidator(categoria);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public boolean mismoTitulo(String titulo) {
		return this.titulo.equals(titulo);
	}
	

	public boolean mismaCategoria(Categoria categoria) {
		return this.categoria.equals(categoria);
	}

	public boolean mismoItem(ItemArtifact item) {
		return this.mismoTitulo(item.getTitulo()) && this.mismaCategoria(item.getCategoria());
	}
	
}
