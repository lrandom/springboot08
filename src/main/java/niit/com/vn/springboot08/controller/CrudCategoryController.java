package niit.com.vn.springboot08.controller;

import niit.com.vn.springboot08.entities.Category;
import niit.com.vn.springboot08.repositories.CategoryRepository;
import niit.com.vn.springboot08.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller("crudCategoryController")
@RequestMapping(value = "/admin/categories")
public class CrudCategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/add")
    public String add(Model model) {
        return "categories/add";
    }

    @PostMapping("/add")
    public String add(@RequestParam("name") String name, Model model) {
        categoryService.saveCategory(name);
        return "redirect:/admin/categories/add";
    }

    @GetMapping("/")
    public String list(Model model) {
        Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("list", categories);
        return "categories/list";
    }
}
