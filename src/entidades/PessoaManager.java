/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import interfaces.IPessoaDao;
import java.util.List;

/**
 *
 * @author mathe
 */
public class PessoaManager {
    private IPessoaDao ipessoaDao;

    public PessoaManager(IPessoaDao ipessoaDao) {
        this.ipessoaDao = ipessoaDao;
    }
    
    public boolean validaDados(Pessoa pessoa){
        List<Pessoa> lista = ipessoaDao.listar();
        for(Pessoa p : lista){
            if(p.getEmail().equals(pessoa.getEmail())){
                return false;
            }
        }
        return true;
    }
    
    public boolean inserir(Pessoa pessoa){
        if(validaDados(pessoa)){
            return ipessoaDao.inserir(pessoa);
        }else{
            return false;
        }
    }
    
    public boolean atualizar(Pessoa pessoa){
        if(!validaDados(pessoa)){
            return ipessoaDao.atualizar(pessoa);
        }else{
            return false;
        }
    }
    
    public boolean deletar(Pessoa pessoa){
        if(!validaDados(pessoa)){
            return ipessoaDao.deletar(pessoa);
        }else{
            return false;
        }
    }
    
    public List<Pessoa> listar(){
        return ipessoaDao.listar();
    }
}
