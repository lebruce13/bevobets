package com.lebruce.bevobets.api.controller;


import com.lebruce.bevobets.api.model.Bet;
import com.lebruce.bevobets.api.model.User;
import com.lebruce.bevobets.api.services.BetService;
import com.lebruce.bevobets.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bets")
public class BetController {
    @Autowired
    private BetService betService;

    @Autowired
    private UserService userService;

    @PostMapping("/place")
    public ResponseEntity<Bet> placeBet(@RequestBody Bet request, Principal principal) {
        Optional<User> user = userService.findByUsername(principal.getName());
        Bet bet = betService.placeBet(user.orElse(null), request.getGameId(), request.getBetAmount(), request.getBetChoice());
        return ResponseEntity.ok(bet);
    }

    @GetMapping("/my-bets")
    public ResponseEntity<List<Bet>> getMyBets(Principal principal) {
        Optional<User> user = userService.findByUsername(principal.getName());
        List<Bet> bets = betService.getAllBets(user.get().getId());
        return ResponseEntity.ok(bets);
    }
}
