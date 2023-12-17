package se.ifmo.web.lab3.persistence.repository;

import jakarta.persistence.*;
import se.ifmo.web.lab3.configuration.EntityManagerFactoryConfiguration;
import se.ifmo.web.lab3.persistence.model.Attempt;


public class AttemptRepository {
    @PersistenceContext
    private final EntityManager entityManager = EntityManagerFactoryConfiguration.getEntityManager();

    public Attempt addAttempt(Attempt attempt) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(attempt);
        transaction.commit();
        return attempt;
    }
}
