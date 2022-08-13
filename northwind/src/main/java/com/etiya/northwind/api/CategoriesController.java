package com.etiya.northwind.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryGetResponse;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;


@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
	private CategoryService categoryService;

	@Autowired
	public CategoriesController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateCategoryRequest createCategoryRequest) {
		this.categoryService.add(createCategoryRequest);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody DeleteCategoryRequest deleteCategoryRequest) {
		this.categoryService.delete(deleteCategoryRequest);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
		this.categoryService.update(updateCategoryRequest);
	}
	
	@GetMapping("/getbyid")
	public DataResult<CategoryGetResponse> getById(@RequestParam int id) {
		return this.categoryService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CategoryListResponse>> getAll(){
		return this.categoryService.getAll();
	}
	
	@GetMapping("/getbypageno")
	public DataResult<List<CategoryListResponse>> getByPageNo(int pageNo, int pageSize){
		return this.categoryService.getAllByPageNumber(pageNo, pageSize);
	}
	
	@GetMapping("/getallsortedbydesc")
	public DataResult<List<CategoryListResponse>> getAllSortedByDesc(@RequestParam String field){
		return this.categoryService.getAllSortedByDesc(field);
	}
	
	@GetMapping("/getallsortedbyasc")
	public DataResult<List<CategoryListResponse>> getAllSortedByAsc(@RequestParam String field){
		return this.categoryService.getAllSortedByAsc(field);
	}
}
