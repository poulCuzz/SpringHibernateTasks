package pl.coderslab.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.demo.entities.Author;
import pl.coderslab.demo.services.AuthorDao;

@RequestMapping("/author")
@org.springframework.stereotype.Controller
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/create")
    @ResponseBody
    public String create() {
        Author author = new Author();
        author.setFirstName("William");
        author.setLastName("Szekspir");
        authorDao.saveAuthor(author);
        return "saved";
    }

    @RequestMapping("/read/{id}")
    @ResponseBody
    public String read(@PathVariable Long id) {
        return authorDao.findById(id).toString();
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable Long id) {
        authorDao.findById(id).setLastName("Bancroft");
        authorDao.findById(id).setFirstName("Tony");
        authorDao.update(authorDao.findById(id));
        return "updated";
    }
    @RequestMapping("delete/{id}")
    @ResponseBody
    public String deleted(@PathVariable Long id) {
        authorDao.delete(authorDao.findById(id));
        return "deleted";
    }
}
