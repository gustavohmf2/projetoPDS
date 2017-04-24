package br.com.ProjetoPDS.App.Models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * Representa os dados "não estaticos" do veiculo, informações
 * adicionais que podem ser passadas pelo usuário
 * @author carlos
 *
 */
@Entity
public class InfoExtraVeiculo implements Serializable{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 6577873998629678366L;
	
		@Id
		@Column(name="id_infoExtraVeiculo")
		private String id;
		private Double kmTotal;
		private Double kmMedia;
		private Double kmAnterior;
		@DateTimeFormat(pattern="dd/mm/yyyy")
		private Calendar ultimaTrocaOleo;
		@DateTimeFormat(pattern="dd/mm/yyyy")
		private Calendar ultimaTrocaPneu;
		@DateTimeFormat(pattern="dd/mm/yyyy")
		private Calendar ultimaRevisao;
		
		public InfoExtraVeiculo() {
			// TODO Auto-generated constructor stub
		}

		public Double getKmTotal() {
			return kmTotal;
		}

		public void setKmTotal(Double kmTotal) {
			this.kmTotal = kmTotal;
		}

		public Double getKmMedia() {
			return kmMedia;
		}

		public void setKmMedia(Double kmMedia) {
			this.kmMedia = kmMedia;
		}

		public Calendar getUltimaTrocaOleo() {
			return ultimaTrocaOleo;
		}

		public void setUltimaTrocaOleo(Calendar ultimaTrocaOleo) {
			this.ultimaTrocaOleo = ultimaTrocaOleo;
		}

		public Calendar getUltimaTrocaPneu() {
			return ultimaTrocaPneu;
		}

		public void setUltimaTrocaPneu(Calendar ultimaTrocaPneu) {
			this.ultimaTrocaPneu = ultimaTrocaPneu;
		}
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		public Calendar getUltimaRevisao() {
			return ultimaRevisao;
		}

		public void setUltimaRevisao(Calendar ultimaRevisao) {
			this.ultimaRevisao = ultimaRevisao;
		}
		public Double getKmAnterior() {
			return kmAnterior;
		}

		public void setKmAnterior(Double kmAnterior) {
			this.kmAnterior = kmAnterior;
		}

		
		
		
}
