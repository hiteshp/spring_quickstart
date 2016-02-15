package spring.jdbc.quickstart.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import spring.jdbc.quickstart.model.Consumer;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsumerDao {
    private static Logger LOGGER = LoggerFactory.getLogger(ConsumerDao.class);

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createConsumer(Consumer consumer) {
        String queryCreateConsumer = "insert into Consumer (id, name) values (?,?)";
        String queryCreateAddress = "insert into Address (id, address,country) values (?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(queryCreateConsumer, new Object[] { consumer.getId(),
                consumer.getName() });
        LOGGER.info("Inserted info in Consumer Table");
        jdbcTemplate.update(queryCreateAddress, new Object[] { consumer.getId(),
                consumer.getAddress().getAddress(),
                consumer.getAddress().getCountry() });
        LOGGER.info("Inserted info in Address Table ");
    }

    public Consumer readConsumer(int consumerId){
        String queryReadConsumer = "select id, name from Consumer where id = ?";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        return (Consumer) jdbcTemplate.queryForObject(queryReadConsumer, new Object[]{consumerId}, new RowMapper() {
            public Object mapRow(final ResultSet rs, int rowNum) throws SQLException {
                return new Consumer(){{
                    setId(rs.getInt("id"));
                    setName(rs.getString("name"));
                }};
            }
        });
    }
}
