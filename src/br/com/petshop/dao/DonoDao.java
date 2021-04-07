/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.dao;

import br.com.petshop.modelo.Dono;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author David
 */
public interface DonoDao extends BaseDao<Dono, Long> {
    
    Dono pesquisarDonoPorNome(String nome, Session sessao) throws HibernateException;
    
    Dono pesquisarDonoPorNomeDoAnimal(String nome, Session sessao) throws HibernateException;
    
}
