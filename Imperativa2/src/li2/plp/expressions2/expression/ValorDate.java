package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import java.util.*;
import java.text.*;

/**
 * Objetos desta classe encapsulam valor inteiro.
 */
public class ValorDate extends ValorConcreto<Date> {

	/**
	 * Cria <code>ValorDate</code> contendo o valor fornecido.
	 */
	public ValorDate(Date valor) {
		super(valor);
	}

	/**
	 * Retorna os tipos possiveis desta expressao.
	 * 
	 * @param amb
	 *            o ambiente de compila��o.
	 * @return os tipos possiveis desta expressao.
	 */
	public Tipo getTipo(AmbienteCompilacao amb) {
		return TipoPrimitivo.DATE;
	}

	public ValorDate clone(){
		return new ValorDate(this.valor());
	}
}
