package com.java2nb.novel.service.impl;

import com.java2nb.novel.dao.BookCategoryDao;
import com.java2nb.novel.dao.CategoryDao;
import com.java2nb.novel.domain.BookCategoryDO;
import com.java2nb.novel.domain.CategoryDO;
import com.java2nb.novel.service.BookCategoryService;
import com.java2nb.novel.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class BookCategoryServiceImpl implements BookCategoryService {
	@Autowired
	private BookCategoryDao bookCategoryDao;
	
	@Override
	public BookCategoryDO get(Integer id){
		return bookCategoryDao.get(id);
	}
	
	@Override
	public List<BookCategoryDO> list(Map<String, Object> map){
		return bookCategoryDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bookCategoryDao.count(map);
	}
	
	@Override
	public int save(BookCategoryDO bookCategory){
		bookCategory.setCreateTime(new Date());
		return bookCategoryDao.save(bookCategory);
	}
	
	@Override
	public int update(BookCategoryDO bookCategory){
		bookCategory.setUpdateTime(new Date());
		return bookCategoryDao.update(bookCategory);
	}
	
	@Override
	public int remove(Integer id){
		return bookCategoryDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return bookCategoryDao.batchRemove(ids);
	}
	
}
