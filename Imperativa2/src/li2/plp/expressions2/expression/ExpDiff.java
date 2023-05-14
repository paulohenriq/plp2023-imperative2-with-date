package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;


/**
 * Um objeto desta classe representa uma Expressao de Subtracao.
 */
public class ExpDiff extends ExpBinaria {

    /**
     * Controi uma Expressao de Subtracao com as sub-expressoes especificadas.
     * Assume-se que estas expressoes resultam em <code>ValorInteiro</code>
     * quando avaliadas.
     *
     * @param esq Expressao da esquerda
     * @param dir Expressao da direita
     */
    public ExpDiff(Expressao esq, Expressao dir) {
        super(esq, dir, "---");
    }

    /**
     * Retorna o valor da Expressao de Subtracao.
     */
    public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        ValorDate data1 = (ValorDate)getEsq().avaliar(amb);
        ValorDate data2 = (ValorDate)getDir().avaliar(amb);
    
        LocalDate localDate1 = data1.getValorConvertido();
        LocalDate localDate2 = data2.getValorConvertido();
    
        int diferencaEmDias = (int) ChronoUnit.DAYS.between(localDate1, localDate2);
    
        return new ValorInteiro(diferencaEmDias);
    }    

    /**
     * Realiza a verificacao de tipos desta expressao.
     *
     * @param ambiente o ambiente de compila��o.
     * @return <code>true</code> se os tipos da expressao sao validos;
     *          <code>false</code> caso contrario.
     * @exception VariavelNaoDeclaradaException se existir um identificador
     *          nao declarado no ambiente.
     * @exception VariavelNaoDeclaradaException se existir um identificador
     *          declarado mais de uma vez no mesmo bloco do ambiente.
     */
    protected boolean checaTipoElementoTerminal(AmbienteCompilacao ambiente)
            throws VariavelNaoDeclaradaException,VariavelJaDeclaradaException {
        return (getEsq().getTipo(ambiente).eData() && getDir().getTipo(ambiente).eData());
    }

    /**
     * Retorna os tipos possiveis desta expressao.
     *
     * @param ambiente o ambiente de compila��o.
     * @return os tipos possiveis desta expressao.
     */
    public Tipo getTipo(AmbienteCompilacao ambiente) {
        return TipoPrimitivo.INTEIRO;
    }

    @Override
    public ExpBinaria clone() {
        return new ExpDiff(esq.clone(), dir.clone());
    }
}