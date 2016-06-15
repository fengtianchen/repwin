package com.swu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swu.dao.BookDao;
import com.swu.dao.BorrowMessageDao;
import com.swu.dao.PublishMessageDao;
import com.swu.model.Book;
import com.swu.model.BorrowMessage;
import com.swu.model.PublishMessage;
import com.swu.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	@Autowired
	PublishMessageDao publishMessageDao;
	@Autowired
	BorrowMessageDao borrowMessageDao;

	@SuppressWarnings("unused")
	public List<PublishMessage> listAllPublishMessage() {
		List<Book> bLists = bookDao.listAllBook();
		List<PublishMessage> pLists = publishMessageDao.queryAllPublishMessage();
		return pLists;
	}

	public boolean PublishBook(Book book, PublishMessage publishMessage) {
		if (bookDao.addBook(book) && publishMessageDao.addPublishMessage(publishMessage))
			return true;
		return false;
	}

	public List<PublishMessage> listPublishMessageByType(String bclass) {
		List<PublishMessage> pLists = publishMessageDao.queryPublishByType(bclass);
		return pLists;
	}

	public List<PublishMessage> listPublishMessageByBlurry(String blurry) {
		return publishMessageDao.queryByBlurrystr(blurry);
	}

	public boolean borrowBook(BorrowMessage borrowMessage) {
		if(borrowMessageDao.addBorrowMessage(borrowMessage))
			return true;
		return false;
	}

	public PublishMessage queryPublishMessageById(Integer pid) {
		return publishMessageDao.queryPublishMessageById(pid);
	}
}
