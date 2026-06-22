/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uef.edu.vn.model.Resident;
import uef.edu.vn.service.HouseholdService;
import uef.edu.vn.service.ResidentService;

/**
 *
 * @author LAB12-PC15
 */
@Controller
@RequestMapping("/residents")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @Autowired
    private HouseholdService householdService;

    private final String path = "/WEB-INF/views/";

    // Hiển thị danh sách cư dân 
    @GetMapping
    public String listResidents(Model model) {
        List<Resident> residents = residentService.getAll();
        model.addAttribute("residents", residents);
        model.addAttribute("body", path + "resident/list.jsp");
        return "layout/main";
    }

    // Hiển thị form thêm cư dân 
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("resident", new Resident());
        model.addAttribute("households", householdService.getAll());
        model.addAttribute("body", path + "resident/form.jsp");
        return "layout/main";
    }

    // Xử lý thêm mới cư dân 
    @PostMapping("/add")
    public String addResident(@ModelAttribute Resident resident) {
        residentService.add(resident);
        return "redirect:/residents";
    }

    // Hiển thị form cập nhật cư dân 
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Resident resident = residentService.getById(id);
        model.addAttribute("resident", resident);
        model.addAttribute("households", householdService.getAll());
        model.addAttribute("body", path + "resident/form.jsp");
        return "layout/main";
    }

    // Xử lý cập nhật 
    @PostMapping("/edit")
    public String updateResident(@ModelAttribute Resident resident) {
        residentService.update(resident);
        return "redirect:/residents";
    }

    // Xử lý xóa cư dân 
    @GetMapping("/delete/{id}")
    public String deleteResident(@PathVariable("id") int id) {
        residentService.delete(id);
        return "redirect:/residents";
    }
}
