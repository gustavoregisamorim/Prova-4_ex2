package utfpr.ct.dainf.if62c.pratica.prova4_2;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

/**
 * Linguagem Java
 * a1861840
 */
public class LancamentoComparator implements Comparator<Lancamento>{
    Boolean numero;
    Boolean numero_ascendente;
    Boolean nome_ascendente;
    
    public LancamentoComparator() {
	super();
    }

    @Override
    public int compare(Lancamento t, Lancamento t1) {
            int retorno;
            if(t.getConta().compareTo(t1.getConta()) == 0){
                     retorno = t.getData().compareTo(t1.getData());
            }
            else
                retorno = t.getConta().compareTo(t1.getConta());
            return retorno;
    }
}
