package niit.com.vn.springboot08.controller;

import niit.com.vn.springboot08.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("crudCategoryController")
@RequestMapping(value = "/admin/categories")
public class CrudCategoryController {

    @Autowired
    CategoryDao categoryDao;

    @RequestMapping(value = "/add")
    public String add(@RequestParam(value = "name", defaultValue = "") String name) {
        if (!name.equals("")) {
            categoryDao.insert(name);
        }
        return "redirect:/admin/categories/list";
    }

    @GetMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("list", categoryDao.getAll());
        return "redirect:/admin/categories/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable String id, @RequestParam("name") String name) {
        return "categories/edit";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable String id) {
        categoryDao.delete(Integer.parseInt(id));
        return "redirect:/admin/categories/list";
    }

}
