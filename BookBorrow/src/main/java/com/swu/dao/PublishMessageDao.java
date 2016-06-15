package com.swu.dao;

import java.util.List;

import com.swu.model.PublishMessage;

public interface PublishMessageDao {
	public boolean addPublishMessage(PublishMessage publishMessage); 	//添加发布信息
	public boolean deletePublishMessageById(Integer in);				//按ID删除
	public PublishMessage queryPublishMessageById(Integer in);			//按ID查询
	public boolean updatePublishMessage(PublishMessage publishMessage);	//更新
	public List<PublishMessage> queryAllPublishMessage();				//查询所有书籍信息
	public List<PublishMessage> queryPublishByType(String bclass); 		//按书籍类别查询
	
	public List<PublishMessage> queryByBlurrystr(String blurrystr);		//模糊查询
}
