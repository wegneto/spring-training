package com.example.gscaching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

	private final BookRepository bookRepository;

	public AppRunner(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... arg0) throws Exception {
		logger.info(".... Fetching books");
		logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
		logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
		logger.info("isbn-8910 -->" + bookRepository.getByIsbn("isbn-8910"));
		logger.info("isbn-1112 -->" + bookRepository.getByIsbn("isbn-1112"));
		logger.info("isbn-1314 -->" + bookRepository.getByIsbn("isbn-1314"));
		logger.info("<-- ***** -->");
		logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
		logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
		logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
		logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
	}

}
