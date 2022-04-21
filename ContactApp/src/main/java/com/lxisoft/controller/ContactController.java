package main.java.com.lxisoft.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import main.java.com.lxisoft.dao.ContactDAO;
import main.java.com.lxisoft.model.Contact;

@Controller
public class ContactController {
     
	@Autowired
	private ContactDAO contactDAO;

	@GetMapping("/")
	public String home(Model model) throws SQLException {
		List<Contact> contactList = contactDAO.listAllContact();
		model.addAttribute("contactList", contactList);
		return "home";
	}

	@GetMapping("/create")
	public String createContact(Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("action", "insert");
		return "createOrUpdateContact";
	}

	@PostMapping("/insert")
	public String insertContact(@ModelAttribute Contact contact) throws SQLException {
		contactDAO.insertContact(contact);
		return "redirect:/";
	}

     @PostMapping("/update")
	public String updateContact(@ModelAttribute Contact contact) throws SQLException {
		contactDAO.updateContact(contact);
		return "redirect:/";
	}

	@GetMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable int contactId) throws SQLException {
		Contact contact = new Contact();
		contact.setId(contactId);
		contactDAO.deleteContact(contact);
		return "redirect:/";
	}

	@GetMapping("/edit/{contactId}")
	public String editContact(@PathVariable int contactId, Model model) throws SQLException {
		Contact contact = contactDAO.returnContact(contactId);
		model.addAttribute("contact", contact);
		model.addAttribute("action", "update");
		return "createOrUpdateContact";
	}
}
