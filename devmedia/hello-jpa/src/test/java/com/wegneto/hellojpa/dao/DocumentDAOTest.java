package com.wegneto.hellojpa.dao;

import static com.wegneto.hellojpa.TestUtils.createPerson;
import static com.wegneto.hellojpa.TestUtils.generateDocumentNumber;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

import com.wegneto.hellojpa.entity.Document;
import com.wegneto.hellojpa.entity.Person;

public class DocumentDAOTest {

	private PersonDAO personDAO = new PersonDAO();
	
	private DocumentDAO documentDAO = new DocumentDAO();

	@Test
	public void insert() {
		Person person = createPerson();
		person.setDocument(new Document(generateDocumentNumber("xxx.xxx.xxx-xx"), generateDocumentNumber("xxxxxxxx-xx")));
		personDAO.save(person);

		assertNotNull(person.getId());
	}
	
	@Test
	public void update() {
		Person person = createPerson();
		person.setDocument(new Document(generateDocumentNumber("xxx.xxx.xxx-xx"), generateDocumentNumber("xxxxxxxx-xx")));
		personDAO.save(person);
		
		Document document = documentDAO.findById(person.getDocument().getId());
		document.setCpf(generateDocumentNumber("xxx.xxx.xxx-xx"));
		documentDAO.update(document);

		Assert.assertNotEquals(person.getDocument().getCpf(), document.getCpf());
	}

}
