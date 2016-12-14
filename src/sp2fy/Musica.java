package sp2fy;

/** 
 * Código desenvolvido para o lab05 de LP2-computacao@ufcg 2016.2
 * Yuri Silva - 116110057
 */


import exception.ValidacaoException;
import validacao.Validacao;

public class Musica {
	
	private String titulo;
	private int duracao;
	private String genero;
	private Validacao minhaValidacao;
	
	public Musica(String titulo, int duracao, String genero) throws ValidacaoException {
		
		this.minhaValidacao = new Validacao();
		
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
		result = prime * result + this.getDuracao();
		result = prime * result + ((this.getTitulo() == null) ? 0 : this.getTitulo().hashCode());
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
		if (this.getDuracao() != other.getDuracao())
			return false;
		if (this.getTitulo() == null) {
			if (other.getTitulo() != null)
				return false;
		} else if (!this.getTitulo().equals(other.getTitulo()))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Titulo: " + this.getTitulo() + ", Duracao: " + this.getDuracao() +" minutos" + ", Genero: " + this.getGenero();
	}
	
	

}
