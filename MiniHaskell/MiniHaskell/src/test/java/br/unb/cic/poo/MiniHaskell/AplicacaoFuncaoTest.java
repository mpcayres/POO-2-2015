package br.unb.cic.poo.MiniHaskell;

import java.util.Arrays;
import java.util.List;

import br.unb.cic.poo.MiniHaskell.AmbienteExecucao;
import junit.framework.TestCase;

public class AplicacaoFuncaoTest extends TestCase {

	public void testExpAplFun() {
		AmbienteExecucao amb = AmbienteExecucao.getInstance();
		Expressao v10 = new ValorInteiro(10);
		Expressao v15 = new ValorInteiro(15);
		
		amb.push();
		amb.declaraVariavel("x", v10);
		assertEquals(amb.consultaReferencia("x"), v10);
		
		Expressao soma = new ExpressaoSoma(v10, v15);
		Expressao mult = new ExpressaoMultiplicacao(soma, v10);
		List<String> args = Arrays.asList("Soma_10_15", "Mult_soma_10");
		DecFuncao func = new DecFuncao("10*(10+15)", args, mult);
		amb.declaraFuncao(func);
		assertEquals(func, amb.consultaFuncao("10*(10+15)"));
		amb.pop();
		
		List<Expressao> argsExp = Arrays.asList(soma, mult);
		AplicacaoDeFuncao apl = new AplicacaoDeFuncao("10*(10+15)", argsExp);
		assertEquals((Integer) 250, ((ValorInteiro) apl.avaliar()).getValor());
	}
	
	public void testExpAplComplex() {
		AmbienteExecucao amb = AmbienteExecucao.getInstance();
		Expressao v10 = new ValorInteiro(10);
		Expressao v15 = new ValorInteiro(15);
		Expressao v20 = new ValorInteiro(20);
		Expressao v5  = new ValorInteiro(5);
		
		amb.push();
		amb.declaraVariavel("x", v10);
		assertEquals(amb.consultaReferencia("x"), v10);
		
		Expressao soma2 = new ExpressaoSoma(v5, v15);
		Expressao soma3 = new ExpressaoSoma(soma2, v20);
		Expressao mult2 = new ExpressaoMultiplicacao(soma3, v10);
		
		List<String> args2 = Arrays.asList("Soma_5_15","Soma_soma2_20", "Mult_soma3_10");
		DecFuncao func2 = new DecFuncao("10*(20+(5+15)", args2, mult2);
		amb.declaraFuncao(func2);
		assertEquals(func2, amb.consultaFuncao("10*(20+(5+15)"));
		amb.pop();
		
		List<Expressao> argsExp2 = Arrays.asList(soma2, soma3, mult2);
		AplicacaoDeFuncao ap2 = new AplicacaoDeFuncao("10*(20+(5+15)", argsExp2);
		assertEquals((Integer) 400, ((ValorInteiro) ap2.avaliar()).getValor());
	}
	
	public void testExpAplFatorial() {
		AmbienteExecucao amb = AmbienteExecucao.getInstance();
		Expressao v5  = new ValorInteiro(5);
		
		amb.push();
		amb.declaraVariavel("x", v5);
		assertEquals(amb.consultaReferencia("x"), v5);
		
		Expressao fatorial = new Fatorial(v5);
		
		List<String> args = Arrays.asList("Fatorial_5");
		DecFuncao func = new DecFuncao("5!", args, fatorial);
		amb.declaraFuncao(func);
		assertEquals(func, amb.consultaFuncao("5!"));
		amb.pop();
		
		List<Expressao> argsExp = Arrays.asList(fatorial);
		AplicacaoDeFuncao ap = new AplicacaoDeFuncao("5!", argsExp);
		assertEquals((Integer) 120, ((ValorInteiro) ap.avaliar()).getValor());
	}
	
	public void testExpAplMoreComplex() {
		AmbienteExecucao amb = AmbienteExecucao.getInstance();
		Expressao v10 = new ValorInteiro(10);
		Expressao v20 = new ValorInteiro(20);
		Expressao v5  = new ValorInteiro(5);
		
		amb.push();
		amb.declaraVariavel("x", v10);
		assertEquals(amb.consultaReferencia("x"), v10);
		
		Expressao fatorial = new Fatorial(v5);
		Expressao mult = new ExpressaoMultiplicacao(v10, v20);
		Expressao soma = new ExpressaoSoma(fatorial, mult);
		
		
		List<String> args2 = Arrays.asList("Fatorial_5","Mult_10_20", "Soma_fatorial_mult");
		DecFuncao func2 = new DecFuncao("(10*20)+(5!)", args2, soma);
		amb.declaraFuncao(func2);
		assertEquals(func2, amb.consultaFuncao("(10*20)+(5!)"));
		amb.pop();
		
		List<Expressao> argsExp2 = Arrays.asList(fatorial, mult, soma);
		AplicacaoDeFuncao ap2 = new AplicacaoDeFuncao("(10*20)+(5!)", argsExp2);
		assertEquals((Integer) 320, ((ValorInteiro) ap2.avaliar()).getValor());
	}
	
}
