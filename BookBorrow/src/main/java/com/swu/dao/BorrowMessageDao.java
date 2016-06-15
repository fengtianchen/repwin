package com.swu.dao;

import com.swu.model.BorrowMessage;

public interface BorrowMessageDao {
	public boolean addBorrowMessage(BorrowMessage borrowMessage);
	public boolean deleteBorrowMessageById(Integer in);
	public BorrowMessage queryBorrowMessageById(Integer in);
}
