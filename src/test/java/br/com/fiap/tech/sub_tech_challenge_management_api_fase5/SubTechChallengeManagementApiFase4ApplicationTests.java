package br.com.fiap.tech.sub_tech_challenge_management_api_fase5;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

@SpringBootTest
@ActiveProfiles("test")
class SubTechChallengeManagementApiFase4ApplicationTests {

    @MockBean
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

}
