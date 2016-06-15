package com.swu.service;

import java.util.List;
import com.swu.model.Book;
import com.swu.model.BorrowMessage;
import com.swu.model.PublishMessage;

public interface BookService {
	public List<PublishMessage> listAllPublishMessage();
	public boolean PublishBook(Book book, PublishMessage publishMessage);
	public List<PublishMessage> listPublishMessageByType(String bclass);
	
	public PublishMessage queryPublishMessageById(Integer pid);
	
	public List<PublishMessage> listPublishMessageByBlurry(String blurry);
	
	public boolean borrowBook(BorrowMessage borrowMessage);
}
