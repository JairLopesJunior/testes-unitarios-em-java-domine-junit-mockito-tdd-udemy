package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws FilmeSemEstoqueException, LocadoraException {
		if(usuario == null) {
			throw new LocadoraException("Usuario vazio");
		}
		
		if(filmes == null || filmes.isEmpty()) {
			throw new LocadoraException("Filme vazio");
		}

		List<Filme> filterFilmes = filmes
			.stream()
			.filter(filme -> filme.getEstoque() == 0)
			.collect(Collectors.toList());
		
		if(filterFilmes.size() > 0) {
			throw new FilmeSemEstoqueException();
		}
		
		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		Double valorTotal = 0d;
		for(Filme f: filmes) {
			valorTotal += f.getPrecoLocacao();
		}
		locacao.setValor(valorTotal);		

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		return locacao;
	}
}












