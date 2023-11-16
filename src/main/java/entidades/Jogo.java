package entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Jogo {
	@Id
	@GeneratedValue
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "DATE")
	private Date dataCadastro = new Date();
	@Column(name = "TM1")
	private String time1;
	@Column(name = "TM2")
	private String time2;
	@Column(name = "GT1")
	private Integer golsTime1;
	@Column(name = "GT2")
	private Integer golsTime2;
	@Column(name = "PT1")
	private Integer pontosTime1;
	@Column(name = "PT2")
	private Integer pontosTime2;
	@Column(name = "VT1")
	private Integer vitoriasTime1;
	@Column(name = "VT2")
	private Integer vitoriasTime2;
	@Column(name = "DT1")
	private Integer derrotasTime1;
	@Column(name = "DT2")
	private Integer derrotasTime2;
	@Column(name = "EMP")
	private Integer empates;
	@Column(name = "GS1")
	private Integer golsSofridosTime1;
	@Column(name = "GS2")
	private Integer golsSofridosTime2;
	@Column(name = "SG1")
	private Integer saldoGolsTime1;
	@Column(name = "SG2")
	private Integer saldoGolsTime2;
	
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
	public Integer getPontosTime1() {
		return pontosTime1;
	}
	public void setPontosTime1(Integer pontosTime1) {
		this.pontosTime1 = pontosTime1;
	}
	public Integer getPontosTime2() {
		return pontosTime2;
	}
	public void setPontosTime2(Integer pontosTime2) {
		this.pontosTime2 = pontosTime2;
	}
	public Integer getVitoriasTime1() {
		return vitoriasTime1;
	}
	public void setVitoriasTime1(Integer vitoriasTime1) {
		this.vitoriasTime1 = vitoriasTime1;
	}
	public Integer getVitoriasTime2() {
		return vitoriasTime2;
	}
	public void setVitoriasTime2(Integer vitoriasTime2) {
		this.vitoriasTime2 = vitoriasTime2;
	}
	public Integer getDerrotasTime1() {
		return derrotasTime1;
	}
	public void setDerrotasTime1(Integer derrotasTime1) {
		this.derrotasTime1 = derrotasTime1;
	}
	public Integer getDerrotasTime2() {
		return derrotasTime2;
	}
	public void setDerrotasTime2(Integer derrotasTime2) {
		this.derrotasTime2 = derrotasTime2;
	}
	public Integer getEmpates() {
		return empates;
	}
	public void setEmpates(Integer empates) {
		this.empates = empates;
	}
	public Integer getGolsSofridosTime1() {
		return golsSofridosTime1;
	}
	public void setGolsSofridosTime1(Integer golsSofridosTime1) {
		this.golsSofridosTime1 = golsSofridosTime1;
	}
	public Integer getGolsSofridosTime2() {
		return golsSofridosTime2;
	}
	public void setGolsSofridosTime2(Integer golsSofridosTime2) {
		this.golsSofridosTime2 = golsSofridosTime2;
	}
	public Integer getSaldoGolsTime1() {
		return saldoGolsTime1;
	}
	public void setSaldoGolsTime1(Integer saldoGolsTime1) {
		this.saldoGolsTime1 = saldoGolsTime1;
	}
	public Integer getSaldoGolsTime2() {
		return saldoGolsTime2;
	}
	public void setSaldoGolsTime2(Integer saldoGolsTime2) {
		this.saldoGolsTime2 = saldoGolsTime2;
	}
	
}
