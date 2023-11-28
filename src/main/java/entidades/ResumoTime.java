package entidades;

public class ResumoTime {
	
	String timeDaVez;
	private int pontuacao;
	private int vitorias;
	private int derrotas;
	private int empates;
	private int gols_marcados;
	private int gols_sofridos;
	private int saldo_gols;
	
	public ResumoTime(String timeDaVez, int pontuacao, int vitorias, int derrotas, int empates, int gols_marcados,
			int gols_sofridos, int saldo_gols) {
		super();
		this.timeDaVez = timeDaVez;
		this.pontuacao = pontuacao;
		this.vitorias = vitorias;
		this.derrotas = derrotas;
		this.empates = empates;
		this.gols_marcados = gols_marcados;
		this.gols_sofridos = gols_sofridos;
		this.saldo_gols = saldo_gols;
	}

	
	public String getTimeDaVez() {
		return timeDaVez;
	}

	public void setTimeDaVez(String timeDaVez) {
		this.timeDaVez = timeDaVez;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getGols_marcados() {
		return gols_marcados;
	}

	public void setGols_marcados(int gols_marcados) {
		this.gols_marcados = gols_marcados;
	}

	public int getGols_sofridos() {
		return gols_sofridos;
	}

	public void setGols_sofridos(int gols_sofridos) {
		this.gols_sofridos = gols_sofridos;
	}

	public int getSaldo_gols() {
		return saldo_gols;
	}

	public void setSaldo_gols(int saldo_gols) {
		this.saldo_gols = saldo_gols;
	}
}
