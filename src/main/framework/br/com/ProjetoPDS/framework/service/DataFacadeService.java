package br.com.ProjetoPDS.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ProjetoPDS.App.Repository.AlertaRepository;
import br.com.ProjetoPDS.App.Repository.CheckInRepository;
import br.com.ProjetoPDS.App.Repository.ClienteRepository;
import br.com.ProjetoPDS.App.Repository.EnderecoRepository;
import br.com.ProjetoPDS.App.Repository.InfoExtraVeiculoRepository;
import br.com.ProjetoPDS.App.Repository.MarcaModeloRepository;
import br.com.ProjetoPDS.App.Repository.OficinaRepository;
import br.com.ProjetoPDS.App.Repository.OrcamentoRepository;
import br.com.ProjetoPDS.App.Repository.PecaRepository;
import br.com.ProjetoPDS.App.Repository.ServicoRepository;
import br.com.ProjetoPDS.App.Repository.VeiculoRepository;

@Service
public class DataFacadeService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OficinaRepository oficinaRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private InfoExtraVeiculoRepository infoExtraVeiculoRepository;
	@Autowired
	private MarcaModeloRepository marcaModeloRepository;
	@Autowired
	private OrcamentoRepository orcamentoRepository;
	@Autowired
	private PecaRepository pecaRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private AlertaRepository alertaRepository;
	@Autowired
	private CheckInRepository checkInRepository;

	public AlertaRepository getAlertaRepository() {
		return alertaRepository;
	}

	public void setAlertaRepository(AlertaRepository alertaRepository) {
		this.alertaRepository = alertaRepository;
	}

	public InfoExtraVeiculoRepository getInfoExtraVeiculoRepository() {
		return infoExtraVeiculoRepository;
	}

	public void setInfoExtraVeiculoRepository(InfoExtraVeiculoRepository infoExtraVeiculoRepository) {
		this.infoExtraVeiculoRepository = infoExtraVeiculoRepository;
	}

	public MarcaModeloRepository getMarcaModeloRepository() {
		return marcaModeloRepository;
	}

	public void setMarcaModeloRepository(MarcaModeloRepository marcaModeloRepository) {
		this.marcaModeloRepository = marcaModeloRepository;
	}

	public OrcamentoRepository getOrcamentoRepository() {
		return orcamentoRepository;
	}

	public void setOrcamentoRepository(OrcamentoRepository orcamentoRepository) {
		this.orcamentoRepository = orcamentoRepository;
	}

	public PecaRepository getPecaRepository() {
		return pecaRepository;
	}

	public void setPecaRepository(PecaRepository pecaRepository) {
		this.pecaRepository = pecaRepository;
	}

	public VeiculoRepository getVeiculoRepository() {
		return veiculoRepository;
	}

	public void setVeiculoRepository(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}

	public ServicoRepository getServicoRepository() {
		return servicoRepository;
	}

	public void setServicoRepository(ServicoRepository servicoRepository) {
		this.servicoRepository = servicoRepository;
	}

	public ClienteRepository getClienteRepository() {
		return clienteRepository;
	}

	public void setClienteRepository(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public OficinaRepository getOficinaRepository(){
		return oficinaRepository;
	}
	
	public void setOficinaRepository(OficinaRepository oficinaRepository){
		this.oficinaRepository = oficinaRepository;
	}

	public EnderecoRepository getEnderecoRepository() {
		return enderecoRepository;
	}

	public void setEnderecoRepository(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	public CheckInRepository getCheckInRepository() {
		return checkInRepository;
	}

	public void setCheckInRepository(CheckInRepository checkInRepository) {
		this.checkInRepository = checkInRepository;
	}
	

	
}
