package entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
	@NamedQuery(name = "listarJogosTime", query = "select j from Jogo j where j.time1 = :time or j.time2 = :time"),
	@NamedQuery(name= "ETA", query = "select j from Jogo j where j.time1 = a or j.time2 = a "),
	@NamedQuery(name= "ETB", query = "select j from Jogo j where j.time1 = b or j.time2 = b "),
	@NamedQuery(name= "ETC", query = "select j from Jogo j where j.time1 = c or j.time2 = c ")
//	@NamedQuery(
//	        name = "ET",
//	        query = "select " +
//	                "    time, " +
//	                "    sum(pontuacao) as pontuacao, " +
//	                "    sum(case when resultado = 'Vitoria' then 1 else 0 end) as numero_vitorias, " +
//	                "    sum(case when resultado = 'Derrota' then 1 else 0 end) as numero_derrotas, " +
//	                "    sum(case when resultado = 'Empate' then 1 else 0 end) as numero_empates, " +
//	                "    sum(gols_marcados) as gols_marcados, " +
//	                "    sum(gols_sofridos) as gols_sofridos, " +
//	                "    sum(gols_marcados - gols_sofridos) as saldo_gols " +
//	                "from ( " +
//	                "    select " +
//	                "        j.time1 as time, " +
//	                "        j.golsTime1 as gols_marcados, " +
//	                "        j.golsTime2 as gols_sofridos, " +
//	                "        case " +
//	                "            when j.time1 = 'a' and j.golsTime1 > j.golsTime2 then 3 " +
//	                "            when j.time1 = 'a' and j.golsTime1 < j.golsTime2 then 0 " +
//	                "            when j.time1 = 'a' and j.golsTime1 = j.golsTime2 then 1 " +
//	                "            when j.time1 = 'b' and j.golsTime1 > j.golsTime2 then 3 " +
//	                "            when j.time1 = 'b' and j.golsTime1 < j.golsTime2 then 0 " +
//	                "            when j.time1 = 'b' and j.golsTime1 = j.golsTime2 then 1 " +
//	                "            when j.time1 = 'c' and j.golsTime1 > j.golsTime2 then 3 " +
//	                "            when j.time1 = 'c' and j.golsTime1 < j.golsTime2 then 0 " +
//	                "            when j.time1 = 'c' and j.golsTime1 = j.golsTime2 then 1 " +
//	                "        end as pontuacao, " +
//	                "        case " +
//	                "            when j.time1 = 'a' and j.golsTime1 > j.golsTime2 then 'Vitoria' " +
//	                "            when j.time1 = 'a' and j.golsTime1 < j.golsTime2 then 'Derrota' " +
//	                "            when j.time1 = 'a' and j.golsTime1 = j.golsTime2 then 'Empate' " +
//	                "            when j.time1 = 'b' and j.golsTime1 > j.golsTime2 then 'Vitoria' " +
//	                "            when j.time1 = 'b' and j.golsTime1 < j.golsTime2 then 'Derrota' " +
//	                "            when j.time1 = 'b' and j.golsTime1 = j.golsTime2 then 'Empate' " +
//	                "            when j.time1 = 'c' and j.golsTime1 > j.golsTime2 then 'Vitoria' " +
//	                "            when j.time1 = 'c' and j.golsTime1 < j.golsTime2 then 'Derrota' " +
//	                "            when j.time1 = 'c' and j.golsTime1 = j.golsTime2 then 'Empate' " +
//	                "       end as resultado " +
//	                "    from Jogo j" +
//	                "    union all " +
//	                "    select " +
//	                "        j.time2 as time, " +
//	                "        j.golsTime2 as gols_marcados, " +
//	                "        j.golsTime1 as gols_sofridos, " +
//	                "        case " +
//	                "            when j.time2 = 'a' and j.golsTime2 > j.golsTime1 then 3 " +
//	                "            when j.time2 = 'a' and j.golsTime2 < j.golsTime1 then 0 " +
//	                "            when j.time2 = 'a' and j.golsTime2 = j.golsTime1 then 1 " +
//	                "            when j.time2 = 'b' and j.golsTime2 > j.golsTime1 then 3 " +
//	                "            when j.time2 = 'b' and j.golsTime2 < j.golsTime1 then 0 " +
//	                "            when j.time2 = 'b' and j.golsTime2 = j.golsTime1 then 1 " +
//	                "            when j.time2 = 'c' and j.golsTime2 > j.golsTime1 then 3 " +
//	                "            when j.time2 = 'c' and j.golsTime2 < j.golsTime1 then 0 " +
//	                "            when j.time2 = 'c' and j.golsTime2 = j.golsTime1 then 1 " +
//	                "        end as pontuacao, " +
//	                "        case " +
//	                "            when j.time2 = 'a' and j.golsTime2 > j.golsTime1 then 'Vitoria' " +
//	                "            when j.time2 = 'a' and j.golsTime2 < j.golsTime1 then 'Derrota' " +
//	                "            when j.time2 = 'a' and j.golsTime2 = j.golsTime1 then 'Empate' " +
//	                "            when j.time2 = 'b' and j.golsTime2 > j.golsTime1 then 'Vitoria' " +
//	                "            when j.time2 = 'b' and j.golsTime2 < j.golsTime1 then 'Derrota' " +
//	                "            when j.time2 = 'b' and j.golsTime2 = j.golsTime1 then 'Empate' " +
//	                "            when j.time2 = 'c' and j.golsTime2 > j.golsTime1 then 'Vitoria' " +
//	                "            when j.time2 = 'c' and j.golsTime2 < j.golsTime1 then 'Derrota' " +
//	                "            when j.time2 = 'c' and j.golsTime2 = j.golsTime1 then 'Empate' " +
//	                "        end as resultado " +
//	                "    from Jogo j" +
//	                ") as subquery " +
//	                "group by time")
	})

@Entity
public class Jogo {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_jogo")
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "DATE")
	private Date dataCadastro = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "DATE")
	private Date dataPartida;
	@Column(name = "time_1")
	private String time1;
	@Column(name = "time_2")
	private String time2;
	@Column(name = "gols_time_1")
	private Integer golsTime1;
	@Column(name = "gols_time_2")
	private Integer golsTime2;
	private String time;
	private Integer pontuacao;
	private Integer vitorias;
	private Integer derrotas;
	private Integer empates;
	private Integer gols_marcados;
	private Integer gols_sofridos;
	private Integer saldo_gols;
	
	@Override
	public String toString() {
		return "Jogo [id=" + id + ", dataCadastro=" + dataCadastro + ", dataPartida=" + dataPartida + ", time1=" + time1
				+ ", time2=" + time2 + ", golsTime1=" + golsTime1 + ", golsTime2=" + golsTime2 + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataPartida() {
		return dataPartida;
	}
	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public Integer getGolsTime1() {
		return golsTime1;
	}
	public void setGolsTime1(Integer golsTime1) {
		this.golsTime1 = golsTime1;
	}
	public Integer getGolsTime2() {
		return golsTime2;
	}
	public void setGolsTime2(Integer golsTime2) {
		this.golsTime2 = golsTime2;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
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

	public Integer getGols_marcados() {
		return gols_marcados;
	}

	public void setGols_marcados(Integer gols_marcados) {
		this.gols_marcados = gols_marcados;
	}

	public Integer getGols_sofridos() {
		return gols_sofridos;
	}

	public void setGols_sofridos(Integer gols_sofridos) {
		this.gols_sofridos = gols_sofridos;
	}

	public Integer getSaldo_gols() {
		return saldo_gols;
	}

	public void setSaldo_gols(Integer saldo_gols) {
		this.saldo_gols = saldo_gols;
	}
	
}
