package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "time_b")
public class TimeB {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_time_a", nullable = false)
	private Integer id;
	@Column(name = "gols", nullable = false)
	private Integer golsTime;
	@Column(nullable = false)
	private Integer pontos;
	@Column(nullable = false)
	private Integer vitorias;
	@Column(nullable = false)
	private Integer derrotas;
	@Column(nullable = false)
	private Integer empates;
	@Column(name = "gols_sofridos", nullable = false)
	private Integer golsSofridos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGolsTime() {
		return golsTime;
	}
	public void setGolsTime(Integer golsTime) {
		this.golsTime = golsTime;
	}
	public Integer getPontos() {
		return pontos;
	}
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}
	public Integer getVitorias() {
		return vitorias;
	}
	public void setVitorias(Integer vitorias) {
		this.vitorias = vitorias;
	}
	public Integer getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(Integer derrotas) {
		this.derrotas = derrotas;
	}
	public Integer getEmpates() {
		return empates;
	}
	public void setEmpates(Integer empates) {
		this.empates = empates;
	}
	public Integer getGolsSofridos() {
		return golsSofridos;
	}
	public void setGolsSofridos(Integer golsSofridos) {
		this.golsSofridos = golsSofridos;
	}
}
