package com.goupang.www.dao.sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.goupang.www.dto.sample.Sample;

@Repository
public class SampleDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public SampleDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<Sample> samRowMapper = new RowMapper<Sample>() {
		@Override
		public Sample mapRow(ResultSet rs, int rowNum) throws SQLException {
			Sample sample = new Sample(rs.getInt("s_no"), rs.getString("s_name"));
			//객체에 직접 값을 주입해야 할 경우
			sample.setS_name(rs.getString("s_name"));
			return sample;
		}

	};

	public List<Sample> selectAll() {
		List<Sample> results = jdbcTemplate.query("SELECT * FROM (\r\n" + 
				"        SELECT ROW_NUMBER() OVER (ORDER BY s_no) NUM, A.*\r\n" + 
				"        FROM sampletable A\r\n" + 
				"        ORDER BY s_no\r\n" + 
				"        )\r\n" + 
				"    WHERE NUM BETWEEN 1 AND 10", samRowMapper);
		return results;
	}


}
