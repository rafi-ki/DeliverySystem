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
    public void add(T Object);
    public void update(long id, T Object);
    public void delete(long id);
    public Iterable<T> getAll();
    public T getById(int id);
}
