package com.wegneto.spring_data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.wegneto.spring_data.repository.AddressRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = { "/clear_db.sql", "/aula37.sql" })
public class Aula37Test {

}
