package com.installfuturecase.InstallFutureBackendCase.Controller;


import com.installfuturecase.InstallFutureBackendCase.DataAccess.TotalSpending.SpendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/totalspending")
public class TotalSpendingController {


    private final SpendingRepository spendingRepository;

    @Autowired
    public TotalSpendingController(SpendingRepository spendingRepository) {
        this.spendingRepository = spendingRepository;
    }

    @GetMapping("/{username}")
    public int getTotalSpendingByUsername(@PathVariable String username) {
        int totalSpending = spendingRepository.getTotalSpendingByUsername(username);

        return totalSpending;
    }

    @GetMapping("/get")
    public int getCurrentTotalSpending(@CurrentSecurityContext(expression = "authentication.name") String username) {
        int totalSpending = spendingRepository.getTotalSpendingByUsername(username);

        return totalSpending;
    }

}
