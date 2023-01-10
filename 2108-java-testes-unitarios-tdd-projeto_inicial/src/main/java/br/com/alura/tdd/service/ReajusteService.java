package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario func, Desempenho desempenho) {

		BigDecimal percentual = desempenho.precentualReajuste();
		BigDecimal reajuste = func.getSalario().multiply(percentual);
		func.reajustarSalario(reajuste);

	}

}
