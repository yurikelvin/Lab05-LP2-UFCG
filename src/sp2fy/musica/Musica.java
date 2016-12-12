package sp2fy.musica;

import exception.ValidacaoException;
import validacao.Validacao;

public class Musica {
	
	private String titulo;
	private int duracao;
	private String genero;
	private Validacao minhaValidacao;
	
	public Musica(String titulo, int duracao, String genero) throws ValidacaoException {
		
		minhaValidacao = new Validacao();
		
		minhaValidacao.validaMusica(titulo, duracao, genero);
		
		this.titulo = titulo;
		this.duracao = duracao;
		this.genero = genero;
		
	}
	
	// gets
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public int getDuracao() {
		return this.duracao;
	}
	
	public String getGenero() {
		return this.genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		if (duracao != other.duracao)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Titulo: " + this.titulo + ", Duracao: " + this.duracao +" minutos" + ", Genero: " + this.genero;
	}
	
	

}
