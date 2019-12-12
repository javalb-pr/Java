package by.gsu.pms.lr12.controller;

import by.gsu.pms.lr12.domain.User;
import by.gsu.pms.lr12.repo.TicketRepo;
import by.gsu.pms.lr12.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TicketRepo ticketRepo;

    @GetMapping("/showAllByTicket/{id}")
    public String users(@PathVariable(name = "id") Long ticketId, Model model){
        model.addAttribute("users", userRepo.findAllByTicketId(ticketId));
        return "users";
    }

    @PostMapping("/addUser/{ticketId}")
    private String addUser(@PathVariable(name = "ticketId") Long ticketId, User user, Model model){
        user.setTicket(ticketRepo.getOne(ticketId));
        userRepo.save(user);
        model.addAttribute("users", userRepo.findAllByTicketId(ticketId));
        return "users";
    }
}
