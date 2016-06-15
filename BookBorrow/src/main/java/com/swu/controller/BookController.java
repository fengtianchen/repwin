package com.swu.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.swu.model.Book;
import com.swu.model.BorrowMessage;
import com.swu.model.PublishMessage;
import com.swu.model.User;
import com.swu.service.BookService;
import com.swu.service.UserService;
import com.swu.util.Pager;

@Controller
@RequestMapping("/")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;

	@RequestMapping(value="/publishbook", method=RequestMethod.POST)
	public String publishBook(Book book, PublishMessage publishMessage, ModelMap model, HttpSession session,
			MultipartFile image) throws Exception{
		System.out.println("文件长度: " + image.getSize());
        System.out.println("文件类型: " + image.getContentType());
        System.out.println("文件名称: " + image.getName());
        System.out.println("文件原名: " + image.getOriginalFilename());
		String imageUrl = "D://EclipseWS/BookBorrow/src/main/webapp/upload/"+image.getOriginalFilename();
        FileUtils.copyInputStreamToFile(image.getInputStream(), new File(imageUrl));
		User user = (User) session.getAttribute("user");
		book.setBookimage(image.getOriginalFilename());
		publishMessage.setPuser(user);
		publishMessage.setPbook(book);
		if (bookService.PublishBook(book, publishMessage)){
			model.addAttribute("publishMsg", "插入成功!");
			return "publish";
		}
		return "publish";
	}
	
	@RequestMapping("/browse")
	public String toBrowsePage(ModelMap model){
		List<PublishMessage> lists = bookService.listAllPublishMessage();
		List<PublishMessage> subList = lists.subList(0, 4);
		model.addAttribute("lists", subList);
		return "browse";
	}
	
	@RequestMapping("/index")
	public String toIndexPage(ModelMap model){
		List<PublishMessage> lists = bookService.listAllPublishMessage();
		model.addAttribute("lists", lists);
		return "index";
	}
	
	@RequestMapping("/")
	public String toIndexPage2(ModelMap model){
		List<PublishMessage> lists = bookService.listAllPublishMessage();
		model.addAttribute("lists", lists);
		return "index";
	}
	
	@RequestMapping("/listbytype")
	public String fictionBook(ModelMap model, @RequestParam("bclass")String bclass){
		List<PublishMessage> lists = bookService.listPublishMessageByType(bclass);
		model.addAttribute("lists", lists);
		return "browse";
	}
	
	@RequestMapping("/listblurry")
	public String blurryBook(ModelMap model, String blurrystr){
		List<PublishMessage> lists = bookService.listPublishMessageByBlurry(blurrystr);
		model.addAttribute("lists", lists);
		return "browse";
	}
	
	@RequestMapping("/borrow")
	public String toBorrowPage(ModelMap model, @RequestParam("pid") Integer pid){
		PublishMessage publishMessage = bookService.queryPublishMessageById(pid);
		model.addAttribute("publishMessage", publishMessage);
		model.addAttribute("pid", pid);
		return "borrow";
	}
	@RequestMapping("/borrowbook")
	public String borrowBook(ModelMap model, BorrowMessage borrowMessage, Integer borrowuserid, Integer publishmessageid){
		PublishMessage publishMessage = bookService.queryPublishMessageById(publishmessageid);
		User user = userService.queryUserById(borrowuserid);
		borrowMessage.setPublishMessage(publishMessage);
		borrowMessage.setBuser(user);
		
		if(bookService.borrowBook(borrowMessage)){
			model.addAttribute("borrowMsg", "借阅成功！");
		}else{
			model.addAttribute("borrowMsg", "借阅失败！");
		}
		return "borrow";
	}
	
	@RequestMapping("/booklist")
	public String listPageBook(ModelMap model, @RequestParam("page") Integer pageNo){
		List<PublishMessage> lists = bookService.listAllPublishMessage();
		Pager pager = new Pager(pageNo, lists.size());
		int fromIndex = (pager.getCurrentPage()-1)*pager.getPageSize();
		int toIndex = 0;
		if(pager.getCurrentPage()*pager.getPageSize() >= lists.size()){
			toIndex = pager.getTotalSize();
		}else{
			toIndex = pager.getCurrentPage()*pager.getPageSize();
		}
		List<PublishMessage> pageList = lists.subList(fromIndex, toIndex);
		model.addAttribute("pager", pager);
		model.addAttribute("lists", pageList);
		return "browse";
	}
	
	
}
