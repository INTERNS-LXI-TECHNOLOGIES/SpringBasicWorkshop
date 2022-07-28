package main.java.com.lxisoft.controller;

import main.java.com.lxisoft.entity.Word;
import main.java.com.lxisoft.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    private static final Logger LOGGER = Logger.getLogger(DictionaryController.class.getName());

    @GetMapping("/")

    public String home(Model model)  {
        List<Word> wordsList =dictionaryService.listAllWords();
        model.addAttribute("wordsList", wordsList);

        LOGGER.info("wordList" + wordsList);
        return "data-list";
    }

    @PostMapping("/save")
    public String saveWord(@ModelAttribute Word word) {
        dictionaryService.saveWord(word);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String createWord(Model model) {

        model.addAttribute("word", new Word());
        model.addAttribute("caption", "ADD NEW WORD");

        return "data-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        dictionaryService.deleteWord(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editCar(@PathVariable int id, Model model) {
        Word word = dictionaryService.getWord(id);
        model.addAttribute("word", word);
        model.addAttribute("caption", "EDIT WORD");
        return "data-form";
    }
    @GetMapping("/Login-form")
    public String login() {
        return "Login-form";
    }
}



