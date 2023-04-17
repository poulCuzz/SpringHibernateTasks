package pl.coderslab.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.demo.entities.Author;
import pl.coderslab.demo.entities.Book;
import pl.coderslab.demo.entities.Publisher;
import pl.coderslab.demo.services.AuthorDao;
import pl.coderslab.demo.services.BookDao;
import pl.coderslab.demo.services.PublisherDao;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }


    @GetMapping("/form")
    public String bookFormSuccess(Model model) {
        model.addAttribute(new Book());
        return "book/bookForm";
    }
    @PostMapping("/form")
    @ResponseBody
    public String successForm(Book book) {
        bookDao.saveBook(book);
        return "success";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String saveBook() {
        Author author1 = authorDao.findById(1);
        Author author2 = authorDao.findById(2);
        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);
        Publisher publisher = new Publisher();
        publisher.setName("WeLoveBooks");
        publisherDao.savePublisher(publisher);
        Book book = new Book();
        book.setTitle("Mulan");
        book.setDescription("about wild woman");
        book.setRating(7);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        bookDao.saveBook(book);
        return "saved";
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public String editBook(@PathVariable Long id) {
        Book book = bookDao.findById(id);
        book.setTitle("Harry Potter");
        bookDao.update(book);
        return "edited";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable Long id) {
        return bookDao.findById(id).toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        bookDao.delete(bookDao.findById(id));
        return "deleted";
    }
}
