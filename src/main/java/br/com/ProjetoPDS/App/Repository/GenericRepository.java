package br.com.ProjetoPDS.App.Repository;

import java.io.Serializable;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericRepository<T, I extends Serializable> implements IGenericRepository<T, I>{

    private EntityManagerFactory emf;
    private Class<T> type;
	
	public GenericRepository(Class<T> type, String persistenceUnitName) {
        this.type = type;
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }
}
