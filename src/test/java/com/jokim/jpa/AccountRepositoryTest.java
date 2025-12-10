package com.jokim.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    @DisplayName("[Success]AccountRepository 테스트")
    void testAccountRepository() {
        // arrange
        Account account = new Account();
        account.setName("test");

        // act
        Account savedAccount = accountRepository.save(account);

        // assert
        Optional<Account> foundAccount = accountRepository.findByName("test");
        assertThat(foundAccount).isPresent();
        assertThat(foundAccount.get().getId()).isEqualTo(savedAccount.getId());
        assertThat(foundAccount.get().getName()).isEqualTo(savedAccount.getName());

        Optional<Account> notFoundAccount = accountRepository.findByName("not_found");
        assertThat(notFoundAccount).isNotPresent();
    }
}
