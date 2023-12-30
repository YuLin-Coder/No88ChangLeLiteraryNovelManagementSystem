package com.java2nb.novel.controller;

import com.java2nb.common.utils.PageBean;
import com.java2nb.common.utils.Query;
import com.java2nb.common.utils.R;
import com.java2nb.novel.domain.BookCategoryDO;
import com.java2nb.novel.domain.CategoryDO;
import com.java2nb.novel.service.BookCategoryService;
import com.java2nb.novel.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author chaochunshu
 * @Date 2021/5/8 9:47
 */
@Controller
@RequestMapping("/novel/bookCategory")
public class BookCategoryController {
    @Autowired
    private BookCategoryService bookCategoryService;

    @GetMapping()
    @RequiresPermissions("novel:bookCategory:bookCategory")
    String BookCategory() {
        return "novel/bookCategory/bookCategory";
    }

    @ApiOperation(value = "获取图书类别表列表", notes = "获取图书类别表列表")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("novel:bookCategory:bookCategory")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<BookCategoryDO> categoryList = bookCategoryService.list(query);
        int total = bookCategoryService.count(query);
        PageBean pageBean = new PageBean(categoryList, total);
        return R.ok().put("data", pageBean);
    }

    @ApiOperation(value = "新增图书类别表页面", notes = "新增图书类别表页面")
    @GetMapping("/add")
    @RequiresPermissions("novel:bookCategory:add")
    String add() {
        return "novel/bookCategory/add";
    }

    @ApiOperation(value = "修改图书类别表页面", notes = "修改图书类别表页面")
    @GetMapping("/edit/{id}")
    @RequiresPermissions("novel:bookCategory:edit")
    String edit(@PathVariable("id") Integer id, Model model) {
        BookCategoryDO bookCategory = bookCategoryService.get(id);
        model.addAttribute("bookCategory", bookCategory);
        return "novel/bookCategory/edit";
    }

    @ApiOperation(value = "查看图书类别表页面", notes = "查看图书类别表页面")
    @GetMapping("/detail/{id}")
    @RequiresPermissions("novel:bookCategory:detail")
    String detail(@PathVariable("id") Integer id, Model model) {
        BookCategoryDO bookCategory = bookCategoryService.get(id);
        model.addAttribute("bookCategory", bookCategory);
        return "novel/bookCategory/detail";
    }

    /**
     * 保存
     */
    @ApiOperation(value = "新增图书类别表", notes = "新增图书类别表")
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("novel:bookCategory:add")
    public R save( BookCategoryDO bookCategory) {
        if (bookCategoryService.save(bookCategory) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改图书类别表", notes = "修改图书类别表")
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("novel:bookCategory:edit")
    public R update( BookCategoryDO bookCategory) {
        bookCategoryService.update(bookCategory);
        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除图书类别表", notes = "删除图书类别表")
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("novel:bookCategory:remove")
    public R remove( Integer id) {
        if (bookCategoryService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除图书类别表", notes = "批量删除图书类别表")
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("novel:bookCategory:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        bookCategoryService.batchRemove(ids);
        return R.ok();
    }
}
