package org.kure.example7.generator;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

/**
 * Custom ID generator for Entities
 */
public class CustomIdGenerator implements IdentifierGenerator {

    private final Random random = new Random();

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return random.nextLong();
    }
}
