package br.edu.impacta.ads.aps.jpa.dao;

import java.util.List;

public interface GenericoDao <E>{  
    public void inserir(E e);
    public void alterar(E e);
    public void deletar(Integer id);
    public List<E> listar();
}
