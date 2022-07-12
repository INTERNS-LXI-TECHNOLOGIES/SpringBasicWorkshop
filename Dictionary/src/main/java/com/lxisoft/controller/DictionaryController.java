package main.java.com.lxisoft.controller;
import main.java.com.lxisoft.dao.DictionaryDAO;
import main.java.com.lxisoft.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryDAO dictionaryDAO;

    @GetMapping("/")

    public String home(Model model) throws SQLException {
        List<Word> wordList = dictionaryDAO.listAllWords();
        model.addAttribute("wordList", wordList);
        return "data-list";
    }

    @PostMapping("/insert")
    public String insertWord(@ModelAttribute Word word) throws SQLException {
        dictionaryDAO.insertWord(word);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateWord(@ModelAttribute Word word) throws SQLException {
        dictionaryDAO.updateWord(word);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String createWord(Model model) {

        model.addAttribute("word", new Word());
        model.addAttribute("action", "insert");

        return "data-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteWord(@PathVariable int id) throws SQLException {
        Word word = new Word();
        word.setId(id);
        dictionaryDAO.deleteWord(word);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editWord(@PathVariable int id, Model model) throws SQLException {
        Word word = dictionaryDAO.getWord(id);
        model.addAttribute("word", word);
        model.addAttribute("action", "update");
        return "data-form";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }
}



