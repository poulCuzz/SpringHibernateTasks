package pl.coderslab.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.demo.entities.Publisher;
import pl.coderslab.demo.services.PublisherDao;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/save")
    @ResponseBody
    public String savePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("WeLoveBooks");
        publisherDao.savePublisher(publisher);
        return "saved";
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public String editBook(@PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName("WeHateBooks");
        publisherDao.update(publisher);
        return "edited";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable Long id) {
        return publisherDao.findById(id).toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        publisherDao.delete(publisherDao.findById(id));
        return "deleted";
    }
}
