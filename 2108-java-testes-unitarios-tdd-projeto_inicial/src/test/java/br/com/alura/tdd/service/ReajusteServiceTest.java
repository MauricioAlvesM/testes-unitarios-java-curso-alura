package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario func;

	@BeforeEach
	public void inicializar() {
		//System.out.println("Inicializei");
		service = new ReajusteService();
		func = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
//	@BeforeAll
//	public static void antesDeTodos() {
//		System.out.println("ANTES");
//	}
//	
//	@AfterAll
//	public static void depoisDeTodos() {
//		System.out.println("DEPOIS");
//	}
//	
//	@AfterEach
//	public void finalizar() {
//		System.out.println("Finalizei");
//	}

	@Test
	public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
		service.concederReajuste(func, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), func.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
		service.concederReajuste(func, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), func.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo() {
		service.concederReajuste(func, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), func.getSalario());
	}

}
