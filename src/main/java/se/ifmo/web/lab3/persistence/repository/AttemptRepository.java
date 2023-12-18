package se.ifmo.web.lab3.persistence.repository;

import jakarta.persistence.*;
import se.ifmo.web.lab3.configuration.EntityManagerFactoryConfiguration;
import se.ifmo.web.lab3.persistence.model.Attempt;

import java.util.List;


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

    public List<Attempt> getAttemptsByR(double r) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<Attempt> attempts = entityManager.createQuery(
                "SELECT a FROM Attempt a WHERE a.r=:R", Attempt.class)
                .setParameter("R", r)
                .getResultList();
        transaction.commit();
        return attempts;
    }
}
