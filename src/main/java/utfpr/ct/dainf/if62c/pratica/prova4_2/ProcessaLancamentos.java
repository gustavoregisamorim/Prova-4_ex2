/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica.prova4_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Linguagem Java
 * a1861840
 */
public class ProcessaLancamentos {
    private BufferedReader reader;

    public ProcessaLancamentos(File arquivo) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(arquivo));
    }

    public ProcessaLancamentos(String path) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(path));
    }
    
    private String getNextLine() throws IOException {
        String linha;
        if((linha = reader.readLine())!= null )
            return linha;
        else
            return null;
    }
    
    private Lancamento processaLinha(String linha) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Lancamento l = new Lancamento(0, null, "", null);
        Scanner s = new Scanner(linha);
        l.setConta(s.nextInt());
        l.setData((Date)formatter.parse(s.next()));
        l.setDescricao(s.next());
        l.setValor(s.nextDouble());
        return l;
        
    }
    
    private Lancamento getNextLancamento() throws IOException, ParseException {
        return processaLinha(getNextLine());
    }
    
    public List<Lancamento> getLancamentos() throws IOException, ParseException {
        List<Lancamento> lista = null;
        do
        {
            lista.add(getNextLancamento());
        }while(lista.get(lista.size()-1)!= null);
        return lista;
    }
    
}
