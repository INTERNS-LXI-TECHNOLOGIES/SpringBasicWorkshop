package com.lxisoft.controllers;

import com.lxisoft.model.Doctor;
import com.lxisoft.model.User;
import com.lxisoft.service.DoctorService;
import com.lxisoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = {"/", "/home"})
    public String indexPage() {
        return "index";
    }

    @GetMapping(value = "/admin")
    public ModelAndView adminView(HttpServletRequest request,HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        List<Doctor> doctorList = doctorService.getAllUsers();
        session.setAttribute("dList",doctorList);
        ModelAndView model = new ModelAndView();
        model.addObject("doctorlist",doctorList);
        model.setViewName("adminMenu");
        return model;
    }

    @RequestMapping(value = "/new" ,method=RequestMethod.GET)
    public ModelAndView addUser(ModelAndView model)
    {
        User user = new User();
        model.addObject("user",user);
        model.setViewName("newUser");
        return model;
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public ModelAndView saveUser(@ModelAttribute User user)
    {
        userService.saveUser(user);
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(value = "/newDoctor" ,method=RequestMethod.GET)
    public ModelAndView addDoctor(ModelAndView model)
    {
        Doctor doctor = new Doctor();
        model.addObject("doctor",doctor);
        model.setViewName("add");
        return model;
    }

    @RequestMapping(value = "/addDoctor",method = RequestMethod.GET)
    public ModelAndView saveDoctor(@ModelAttribute Doctor doctor)
    {
        doctorService.saveDoctor(doctor);
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(value = "/editDoctor",method=RequestMethod.GET)
    public ModelAndView editDoctor(HttpServletRequest request)
    {
        int num = Integer.parseInt(request.getParameter("id"));
        Doctor doctor = doctorService.getDoctorById(num);
        ModelAndView model = new ModelAndView();
        model.addObject("doctorById", doctor);
        model.setViewName("editDoctor");
        return model;
    }

    @RequestMapping(value="/edit",method=RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute Doctor doctor)
    {
        doctorService.saveDoctor(doctor);
        return new ModelAndView("redirect:/admin");

    }

    @RequestMapping(value="/deleteDoctor")
    public String deleteDoctor(HttpServletRequest request)
    {
        int did = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        session.setAttribute("dId", did);
        return "delete";
    }

    @RequestMapping(value="/deleteUser")
    public String deleteUser(HttpServletRequest request)
    {
        int did = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        session.setAttribute("dId", did);
        return "delete";
    }

    @RequestMapping(value="/cancelBooking")
    public String cancelBooking(HttpServletRequest request)
    {
        int uid = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        session.setAttribute("uId", uid);
        return "cancel";
    }

    @RequestMapping(value="/deleteuser")
    public ModelAndView cancelUser(HttpServletRequest request)
    {
        int did = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(did);
        return new ModelAndView("redirect:/admin");

    }

    @RequestMapping(value="/delete")
    public ModelAndView delete(HttpServletRequest request)
    {
        int did = Integer.parseInt(request.getParameter("id"));
        doctorService.deleteDoctor(did);
        return new ModelAndView("redirect:/admin");

    }

    @GetMapping(value = "/viewBooking")
    public ModelAndView adminBookingView(HttpServletRequest request,HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        List<User> userList = userService.getAllUsers();
        session.setAttribute("uList",userList);
        ModelAndView model = new ModelAndView();
        model.addObject("userlist",userList);

        List<Doctor> doctorList = doctorService.getAllUsers();
        session.setAttribute("dList",doctorList);
        model.addObject("doctorlist",doctorList);

        model.setViewName("userBookingView");
        return model;
    }

    @RequestMapping(value="/checkBooking")
    public String checkBooking(HttpServletRequest request)
    {
       return "viewbyid";
    }

    @RequestMapping(value="/viewById")
    public ModelAndView viewBooking(HttpServletRequest request)
    {
       String sname = request.getParameter("name");
        HttpSession session = request.getSession();
        session.setAttribute("sname", sname);

        List<User> userList = userService.getAllUsers();
        session.setAttribute("uList",userList);
        ModelAndView model = new ModelAndView();
        model.addObject("userlist",userList);

        List<Doctor> doctorList = doctorService.getAllUsers();
        session.setAttribute("dList",doctorList);
        model.addObject("doctorlist",doctorList);


        model.setViewName("bookingview");
        return model;
    }

}
