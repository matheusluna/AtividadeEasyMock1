/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Pessoa;
import java.util.List;

/**
 *
 * @author mathe
 */
public interface IPessoaDao {
    public boolean inserir(Pessoa pessoa);
    public boolean atualizar(Pessoa pessoa);
    public boolean deletar(Pessoa pessoa);
    public List<Pessoa> listar();
}
