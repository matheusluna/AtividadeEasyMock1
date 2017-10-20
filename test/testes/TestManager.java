/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import entidades.Pessoa;
import entidades.PessoaManager;
import interfaces.IPessoaDao;
import java.util.ArrayList;
import java.util.List;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mathe
 */
public class TestManager {
    
    IPessoaDao ipessoaDao;
    
    @Before
    public void setUp() {
        ipessoaDao = EasyMock.createMock(IPessoaDao.class);
        
    }
    
    @Test
    public void test1(){
        Pessoa pessoa = new Pessoa("111.111.111-11", "Matheus Moreira Luna", 21,
                "matheus@gmail.com", "83998826298", "Cajazeiras");
        
        List<Pessoa> lista = new ArrayList<>();
        EasyMock.expect(ipessoaDao.listar()).andReturn(lista);
        EasyMock.expect(ipessoaDao.inserir(pessoa)).andReturn(true);
        EasyMock.replay(ipessoaDao);
        PessoaManager dao = new PessoaManager(ipessoaDao);
        assertTrue(dao.inserir(pessoa));
    }
    @Test
    public void test2(){
        Pessoa pessoa = new Pessoa("111.111.111-11", "Matheus Moreira Luna", 21,
                "matheus@gmail.com", "83998826298", "Cajazeiras");
        
        List<Pessoa> lista = new ArrayList<>();
        lista.add(pessoa);
        EasyMock.expect(ipessoaDao.listar()).andReturn(lista);
        EasyMock.expect(ipessoaDao.atualizar(pessoa)).andReturn(true);
        EasyMock.replay(ipessoaDao);
        PessoaManager dao = new PessoaManager(ipessoaDao);
        assertTrue(dao.atualizar(pessoa));

    }
    @Test
    public void test3(){
        Pessoa pessoa = new Pessoa("111.111.111-11", "Matheus Moreira Luna", 21,
                "matheus@gmail.com", "83998826298", "Cajazeiras");
        
        List<Pessoa> lista = new ArrayList<>();
        lista.add(pessoa);
        EasyMock.expect(ipessoaDao.listar()).andReturn(lista);
        EasyMock.expect(ipessoaDao.deletar(pessoa)).andReturn(true);
        EasyMock.replay(ipessoaDao);
        PessoaManager dao = new PessoaManager(ipessoaDao);
        assertTrue(dao.deletar(pessoa));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
