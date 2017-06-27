package com.valsoft.controller;
import com.valsoft.service.IBudgetService;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Set;
import com.valsoft.dao.BudgetDAO;
import com.valsoft.dao.RoleDAO;
import com.valsoft.model.Budget;
import com.valsoft.model.Role;
import com.valsoft.service.BudgetService;
import com.valsoft.service.IRoleService;
import com.valsoft.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
@Controller
@RequestMapping("/")
@ComponentScan("com.valsoft")
public class AppController {
    private static final long serialVersionUID = 1L;
    @Autowired
    private IBudgetService budgetService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertBudget(request, response);
                    break;
                case "/delete":
                    deleteBudget(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateBudget(request, response);
                    break;
                default:
                    listBudget(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void listBudget(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Budget> budgetList = budgetService.findAllBudgets();
        request.setAttribute("listBudgets", budgetList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BudgetList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("BudgetForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Budget existingBudget = budgetService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BudgetForm.jsp");
        request.setAttribute("budget", existingBudget);
        dispatcher.forward(request, response);

    }

    private void insertBudget(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        LocalDate localDate = new LocalDate();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
        String formattedDate = request.getParameter(formatter.print(localDate));
       // LocalDate creationDate = Long.parseLong(request.getDateHeader("creationDate"));
       // String creationDate = request.getParameter("creationDate");
        //LocalDate creationDate = request.getDateHeader("creationDate");
        String author = request.getParameter("description");
        String name = request.getParameter("name");

        Budget newBudget = new Budget( author, name, localDate);
        budgetService.saveBudget(newBudget);
        response.sendRedirect("list");
    }

    private void updateBudget(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        //String title = request.getParameter("creationDate");
        String description = request.getParameter("description");
        String name = request.getParameter("name");
        LocalDate localDate = new LocalDate();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
        String formattedDate = request.getParameter(formatter.print(localDate));
        Budget budget = new Budget(id, description, name, localDate);
        budgetService.updateBudget(budget);
        response.sendRedirect("list");
    }

    private void deleteBudget(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        //Budget budget = budgetService.findById(id);
        budgetService.deleteBudgetById(id);
        response.sendRedirect("list");

    }

//    @Autowired
//    IRoleService service;
//
//    @Autowired
//    MessageSource messageSource;
//
//    /*
//     * This method will list all existing employees.
//     */
//    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
//    public String listBudgets(ModelMap model) {
//
//        System.out.println("gfdgfgdg");
//        Role role1 = new Role();
//        role1.setName("sadsadasd");
//        service.saveRole(role1);
//        Role role2  = new Role();
//        role2.setName("qgfsdfsafa");
//        service.saveRole(role2);
//        List<Role> roles = service.findAllRoles();
//        model.addAttribute("roles", roles);
//        System.out.println(roles);
//        return "index";
//    }

    /*
     * This method will provide the medium to add a new employee.
     */
//    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
//    public String newBudget(ModelMap model) {
//        System.out.println("frewnrf");
//        Budget budget = new Budget();
//        model.addAttribute("budget", budget);
//        model.addAttribute("edit", false);
//        return "index";
//    }

    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
//    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
//    public String saveEmployee(Budget budget,
//                               ModelMap model) {
//
//        if (result.hasErrors()) {
//            return "registration";
//        }
//
//        /*
//         * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation
//         * and applying it on field [ssn] of Model class [Employee].
//         *
//         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
//         * framework as well while still using internationalized messages.
//         *
//         */
//        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
//            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
//            result.addError(ssnError);
//            return "registration";
//        }
//
//        service.saveEmployee(employee);
//
//        model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
//        return "success";
//    }
//
//
//    /*
//     * This method will provide the medium to update an existing employee.
//     */
//    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
//    public String editEmployee(@PathVariable String ssn, ModelMap model) {
//        Employee employee = service.findEmployeeBySsn(ssn);
//        model.addAttribute("employee", employee);
//        model.addAttribute("edit", true);
//        return "registration";
//    }
//
//    /*
//     * This method will be called on form submission, handling POST request for
//     * updating employee in database. It also validates the user input
//     */
//    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
//    public String updateEmployee(@Valid Employee employee, BindingResult result,
//                                 ModelMap model, @PathVariable String ssn) {
//
//        if (result.hasErrors()) {
//            return "registration";
//        }
//
//        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
//            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
//            result.addError(ssnError);
//            return "registration";
//        }
//
//        service.updateEmployee(employee);
//
//        model.addAttribute("success", "Employee " + employee.getName()  + " updated successfully");
//        return "success";
//    }
//
//
//    /*
//     * This method will delete an employee by it's SSN value.
//     */
//    @RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
//    public String deleteEmployee(@PathVariable String ssn) {
//        service.deleteEmployeeBySsn(ssn);
//        return "redirect:/list";
//    }
//

}

