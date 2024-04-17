package minihp.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional(readOnly = true)
class ContentRepositoryTest {

    @Autowired
    ContentRepository repository;
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    /*@Test
    void test() {
        repository.findAll();
    }*/
}