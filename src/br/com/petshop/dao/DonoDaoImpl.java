/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.dao;

import br.com.petshop.modelo.Dono;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


public class DonoDaoImpl extends BaseDaoImpl<Dono, Long> implements DonoDao, Serializable {

    @Override
    public Dono pesquisarDonoPorNome(String nome, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Dono where nome like :nome");
        consulta.setParameter("nome","%" + nome + "%");
        return (Dono)consulta.uniqueResult();
    }

    @Override
    public Dono pesquisarDonoPorNomeDoAnimal(String nome, Session sessao) throws HibernateException {
         Query consulta = sessao.createQuery("from Dono d join fetch Animal a where a.nome like :nome");
        consulta.setParameter("nome","%" + nome + "%");
        return (Dono)consulta.uniqueResult();
    }

    @Override
    public Dono pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Dono) sessao.get(Dono.class, id);
    }
    
}
