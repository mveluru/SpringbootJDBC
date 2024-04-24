package com.brite.springbootjdbc.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeRepo {
    private static final Logger log = LoggerFactory.getLogger(EmployeeRepo.class);


    protected DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void setJdbcTemplate(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    protected Employee getEmployeebyId(Integer id) throws EmptyResultDataAccessException {
        String sql = "Select id , name , department from employee where id =?";
        EmployeeMapper employeeMapper = new EmployeeMapper();

     return jdbcTemplate.queryForObject(sql,new Object[] {id},employeeMapper);
    }

    protected List<Employee> getemployees() {
        String sql = "Select id , name , department from employee";
        return jdbcTemplate.query(sql,new EmployeeMapper());

    }

    protected String deleteEmployee(Integer id) {

        String sql = "DELETE from employee  where id = ?";
        int row = jdbcTemplate.update(sql, id);
        if (row > 0) {
            log.info("Employee deleted");
            return "Employee deleted";
        }
        return "Employee not deleted";
    }

    protected String updateEmploye(Employee employee) {

        String sql = "UPDATE employee SET name = ?,department = ? where id = ?";
        int row = jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getId());
        if (row > 0) {
            log.info("Employee updated");
            return "Employee updated";
        }
        return "Employee not updated";

    }

    protected String addEmployee(Employee employee) {
        String sql = "insert into employee(id,name,department) values (?,?,?)";
        int row = jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getDepartment());
        if (row > 0) {
            log.info("Employee added");
            return "Employee added";
        }
        return "Employee not added";
    }

}
