package br.com.ProjetoPDS.App.Models;

import java.util.Calendar;

import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * Representa os dados "não estaticos" do veiculo, informações
 * adicionais que podem ser passadas pelo usuário
 * @author carlos
 *
 */
@Entity
public class InfoExtraVeiculo {
	
		private Double kmTotal;
		private Double kmMedia;
		@DateTimeFormat(pattern="dd/mm/yyyy")
		private Calendar ultimaTrocaOleo;
		@DateTimeFormat(pattern="dd/mm/yyyy")
		private Calendar ultimaTrocaPneu;
		
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
		
		
		
}
