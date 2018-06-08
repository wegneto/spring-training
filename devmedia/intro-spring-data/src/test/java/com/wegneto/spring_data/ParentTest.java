package com.wegneto.spring_data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wegneto.spring_data.entity.Child;
import com.wegneto.spring_data.entity.Parent;
import com.wegneto.spring_data.repository.ParentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentTest {

	@Autowired
	private ParentRepository repository;

	@Test
	public void test1() {
		Child c1 = new Child();
		c1.setName("teste");
		
		List<Child> list = new ArrayList<>();
		list.add(c1);
		
		Parent p1 = new Parent();
		p1.setName("teste");
		p1.setChild(list);
		
		repository.save(p1);
		Assert.assertNotNull(p1.getId());
	}
	
}
