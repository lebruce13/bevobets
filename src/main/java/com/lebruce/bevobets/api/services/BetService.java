package com.lebruce.bevobets.api.services;
import com.lebruce.bevobets.api.repositories.BetRepository;
import com.lebruce.bevobets.api.model.Bet;
import com.lebruce.bevobets.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BetService {
    @Autowired
    private BetRepository betRepository;

    public Bet placeBet(User user, String gameId, double amount, String choice) {
        Bet bet = new Bet();
        bet.setUser(user);
        bet.setGameId(gameId);
        bet.setBetAmount(amount);
        bet.setBetChoice(choice);
        return betRepository.save(bet);
    }

    public List<Bet> getAllBets(Long userId) {
        return betRepository.findByUserId(userId);
    }
}
