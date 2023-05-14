package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.imperative2.util.Data;
import java.time.LocalDate;
import java.util.*;
import java.text.*;

/**
 * Objetos desta classe encapsulam valor inteiro.
 */
public class ValorDate extends ValorConcreto<Data> {
	private LocalDate valorConvertido;
	/**
	 * Cria <code>ValorDate</code> contendo o valor fornecido.
	 */
	public ValorDate(Data valor) {
		super(valor);
		this.valorConvertido = valor.getLocalDate();
	}

	/**
	 * Retorna os tipos possiveis desta expressao.
	 * 
	 * @param amb
	 *            o ambiente de compila��o.
	 * @return os tipos possiveis desta expressao.
	 */
	public Tipo getTipo(AmbienteCompilacao amb) {
		return TipoPrimitivo.DATA;
	}

	public ValorDate clone(){
		return new ValorDate(this.valor());
	}

	public LocalDate getValorConvertido() {
    return this.valorConvertido;
	}
}
