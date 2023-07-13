package com.installfuturecase.InstallFutureBackendCase.ScheduledJob;
import com.installfuturecase.InstallFutureBackendCase.DataAccess.TransactionCalculationRepository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class ScheduledJobs {

    private final TransactionRepository transactionRepository;


    @Autowired
    public ScheduledJobs(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Scheduled(fixedRate = 30000)
    public void calculateTotalTransactionAmountLastWeek() {
        LocalDate startDate = LocalDate.now().minus(7, ChronoUnit.DAYS); // Bugünden 7 gün önceki tarih
        LocalDate endDate = LocalDate.now();

        int totalTransactionAmount = transactionRepository.sumTransactionAmountByTransactionDateBetween(startDate, endDate);
        System.out.println("Son 1 haftadaki toplam harcama miktarı: " + totalTransactionAmount);
    }

    @Scheduled(fixedRate = 60000)
    public void calculateTotalTransactionAmountLastDay() {
        LocalDate currentDate = LocalDate.now(); // Bugünün tarihi
        LocalDate previousDate = currentDate.minusDays(1); // Bir önceki günün tarihi

        int totalTransactionAmount = transactionRepository.sumTransactionAmountByTransactionDateBetween(previousDate,currentDate);
        System.out.println("Son 1 günlük toplam harcama miktarı: " + totalTransactionAmount);
    }

    @Scheduled(fixedRate = 60000)
    public void calculateTotalTransactionAmountLastMonth() {
        LocalDate currentDate = LocalDate.now(); // Bugünün tarihi
        LocalDate previousDate = currentDate.minusDays(30); // Bir önceki ayın tarihi

        int totalTransactionAmount = transactionRepository.sumTransactionAmountByTransactionDateBetween(previousDate,currentDate);
        System.out.println("Son 1 aylık toplam harcama miktarı: " + totalTransactionAmount);
    }

}
