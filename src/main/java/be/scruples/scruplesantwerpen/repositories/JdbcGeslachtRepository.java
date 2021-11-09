package be.scruples.scruplesantwerpen.repositories;

import be.scruples.scruplesantwerpen.domain.Geslacht;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
class JdbcGeslachtRepository implements GeslachtRepository {
    private final JdbcTemplate template;
    private final SimpleJdbcInsert insert;
    private final RowMapper<Geslacht> geslachtmapper = (result, rowNum) ->
            new Geslacht(result.getLong("GenderId"), result.getString("Geslacht"));

    JdbcGeslachtRepository(JdbcTemplate template) {
        this.template = template;
        insert =  new SimpleJdbcInsert(template).withTableName("Geslacht").usingGeneratedKeyColumns("Genderid");

    }

    @Override
    public List<Geslacht> findAll() {
        return template.query("select Genderid, Geslacht from Geslacht order by GenderId", geslachtmapper);
    }
    @Override
    public long create(Geslacht geslacht) {
        return insert.executeAndReturnKey(Map.of("Geslacht", geslacht.getGeslacht())).longValue();
    }

    @Override
    public void delete(Long[] ids) {
        if(ids.length != 0) {
            var sql = "delete from Geslacht where genderId in (" +
                    "?,".repeat(ids.length-1) + "?)";
            template.update(sql, ids);
        }

    }
}
