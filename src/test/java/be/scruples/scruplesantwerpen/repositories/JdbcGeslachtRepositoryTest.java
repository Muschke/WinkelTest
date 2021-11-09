package be.scruples.scruplesantwerpen.repositories;

import be.scruples.scruplesantwerpen.domain.Geslacht;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@Import(JdbcGeslachtRepository.class)
@Sql("/insertGeslacht.sql")
class JdbcGeslachtRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String GESLACHT = "Geslacht";
    private final JdbcGeslachtRepository geslachtRepository;

    JdbcGeslachtRepositoryTest(JdbcGeslachtRepository geslachtRepository) {
        this.geslachtRepository = geslachtRepository;
    }


    @Test
    @DisplayName("controle dat findall evenveel rijen terugbrengt alsdat de tabel verschillende waardes bezit")
    void findAll() {
        assertThat(geslachtRepository.findAll())
                .hasSize(countRowsInTable(GESLACHT))
                .extracting(Geslacht::getGeslacht)
                .isSorted();
    }

    @Test
    @DisplayName("methode create + autmatische nummering ok")
    void create() {
        geslachtRepository.create(new Geslacht(0, "unisex"));
        var id = jdbcTemplate.queryForObject("select Genderid from Geslacht where Geslacht = 'unisex'", Long.class);
        assertThat(id).isPositive();
        assertThat(countRowsInTableWhere(GESLACHT, "Genderid = " + id)).isOne();
    }

    @Test
    @DisplayName("Het verwijderen van alle ids geeft geen rijen als resultaat")
    void delete() {
        var idEen = idVanTestGeslachtEen();
        var idTwee = idVanTestGeslachtTwee();
        geslachtRepository.delete(new Long[] {idEen, idTwee});
        assertThat(countRowsInTableWhere(GESLACHT, "Genderid in (" + idEen + "," + idTwee + ")")).isZero();
    }

    @Test
    @DisplayName("ingave van lege id-set om te verwijderen geeft geen fout")
    void deleteMetLegeArrayGeeftGeenException() {
        geslachtRepository.delete(new Long[]{});
    }

    private long idVanTestGeslachtEen() {
        return jdbcTemplate.queryForObject("select Genderid from Geslacht where Geslacht = 'man'", Long.class);
    }
    private long idVanTestGeslachtTwee() {
        return jdbcTemplate.queryForObject("select Genderid from Geslacht where Geslacht = 'vrouw'", Long.class);
    }
}