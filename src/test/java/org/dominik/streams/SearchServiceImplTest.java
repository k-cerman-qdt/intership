package org.dominik.streams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Author : Bydzovsky Dominik
 * Date Created: 2024/11/22
 */
class SearchServiceImplTest {

    @Test
    public void testFindYoungerThanFindsSomething() {
        List<User> users = List.of(
                createUser("Jack", "Daniels", 20, "English", 20000),
                createUser("Alice", "X", 80, "Spanish", 50000),
                );
        SearchService service = new SearchServiceImpl(users);

        List<User> foundUsers = service.findYoungerUsersThan(21);
        assertEquals(1, foundUsers.size());
        User foundUser = foundUsers.get(0);
        assertEquals("Jack", foundUser.getName());
    }

    // todo implement tests

    private User createUser(String firstName, String lastName, int age, String language, double wage) {
        return null; // todo implement
    }
}