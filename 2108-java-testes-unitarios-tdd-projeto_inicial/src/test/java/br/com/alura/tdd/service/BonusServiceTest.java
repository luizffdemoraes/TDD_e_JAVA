package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaSalarioMuitoAlto() {
		BonusService service = new BonusService();

		// Primeira Op��o
//		assertThrows(IllegalArgumentException.class, 
//				() -> service.calcularBonus(new Funcionario("Luiz", LocalDate.now(), new BigDecimal("25000"))));

		// Segunda Op��o
		try {
			
			service.calcularBonus(new Funcionario("Luiz", LocalDate.now(), new BigDecimal("25000")));
			fail("N�o deu a exception!");
		} catch (Exception e) {
			assertEquals("Funcionario com salario maior do que R$1000 n�o pode receber bonus!", e.getMessage());
		}

	}

	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Luiz", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Luiz", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
