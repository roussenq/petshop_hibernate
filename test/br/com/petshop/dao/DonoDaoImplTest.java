/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.dao;

import br.com.petshop.modelo.Dono;
import br.com.utilitario.UtilGerador;
import static br.com.utilitario.UtilGerador.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class DonoDaoImplTest {

    private Dono dono;
    private DonoDao donoDao;
    private Session sessao;

    public DonoDaoImplTest() {
        donoDao = new DonoDaoImpl();
    }
    
    
    
    //@Test
    public void testSalvarDono() {
        
        dono = new Dono(
                null,
                gerarNome(),
                gerarNumero(3)+"."+gerarNumero(3)+"."+gerarNumero(3)+"-"+gerarNumero(2),
                gerarTelefoneFixo(),
                gerarEmail()
        );
        sessao = HibernateUtil.abrirConexao();
        donoDao.salvarOuAlterar(dono, sessao);
        sessao.close();
        
        assertNotNull(dono.getId());
    }

     //@Test
    public void testAlterarDono() {
        System.out.println("Alterar Dono");
        
        buscarDonoBd();
        dono.setTelefone("(48)3248-1415");
        
    }    
    //@Test
    public void testPesquisarDonoPorNome() {
        System.out.println("pesquisar Dono por nome");

    }

    //@Test
    public void testPesquisarDonoPorNomeDoAnimal() {
        System.out.println("pesquisarDonoPorNomeDoAnimal");

    }

    //@Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");

    }

    private Dono buscarDonoBd() {

        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Dono d join fetch d.animais ");
        List<Dono> donos = consulta.list();
        sessao.close();

        if (donos.isEmpty()) {
            testSalvarDono();
        } else {
            dono = donos.get(0);
        }

        return dono;
    }

    

}
       
