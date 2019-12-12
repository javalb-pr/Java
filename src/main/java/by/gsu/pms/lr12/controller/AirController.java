package by.gsu.pms.lr12.controller;

import by.gsu.pms.lr12.repo.FlightRepo;
import by.gsu.pms.lr12.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AirController {

    @Autowired
    private FlightRepo flightRepo;

    @Autowired
    private TicketRepo ticketRepo;

    @GetMapping("/")
    public String flights(Model model){
        model.addAttribute("flights", flightRepo.findAll());
        return "main";
    }

    @GetMapping("/registrationTicket/{id}")
    public String regTicket(@PathVariable(name = "id") Long ticketId, Model model){
        model.addAttribute("ticketId", ticketId);
        model.addAttribute("ticketCost", ticketRepo.findById(ticketId).get().getCost());
        return "registration";
    }
}
