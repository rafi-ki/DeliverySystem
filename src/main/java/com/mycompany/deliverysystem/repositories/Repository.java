/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deliverysystem.repositories;

/**
 * This Interface defines the Method of a very general Repository
 * @author rafael, dominik
 */
public interface Repository<T> {
    public void add(T Object)throws RepositoryException;
    public void update(long id, T Object)throws RepositoryException;
    public void delete(long id)throws RepositoryException;
    public Iterable<T> getAll()throws RepositoryException;
    public T getById(long id)throws RepositoryException;
}
