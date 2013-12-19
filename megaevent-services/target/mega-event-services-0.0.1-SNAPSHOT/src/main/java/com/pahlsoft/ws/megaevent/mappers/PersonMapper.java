package com.pahlsoft.ws.megaevent.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pahlsoft.ws.megaevent.generated.Person;
import com.pahlsoft.ws.megaevent.generated.Role;

public class PersonMapper implements RowMapper<Person> {

	public Person mapRow(ResultSet rs, int rownum) throws SQLException {
		Person person = new Person();
		
		person.setId(rs.getInt("personID"));
		person.setFirstName(rs.getString("first_name"));
		person.setLastName(rs.getString("last_name"));
		person.setLogin(rs.getString("login"));
		person.setRole(Role.fromValue(rs.getString("role")));
		person.setWorkPhone(rs.getString("work_phone"));
		person.setCellPhone(rs.getString("cell_phone"));
		person.setPager(rs.getString("pager"));
		
		return person;
	}

}
