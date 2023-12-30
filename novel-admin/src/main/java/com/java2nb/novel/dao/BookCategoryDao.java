package com.java2nb.novel.dao;

import com.java2nb.novel.domain.BookCategoryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 新闻类别表
 * @author xiongxy
 * @email 1179705413@qq.com
 * @date 2020-12-01 10:03:41
 */
@Mapper
public interface BookCategoryDao {

	BookCategoryDO get(Integer id);

	List<BookCategoryDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(BookCategoryDO category);
	
	int update(BookCategoryDO category);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
