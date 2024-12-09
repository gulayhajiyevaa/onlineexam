package org.example.oasisinfobyteonlineexamination.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExamScheduler {

    private static LocalDateTime examStartTime;
    private static final int EXAM_DURATION_MINUTES = 60;


    public void startExam() {
        examStartTime = LocalDateTime.now();
        System.out.println("Exam started at: " + examStartTime);
    }

    @Scheduled(fixedRate = 60000) // Check every minute
    public void checkExamStatus() {
        if (examStartTime != null && LocalDateTime.now().isAfter(examStartTime.plusMinutes(EXAM_DURATION_MINUTES))) {
            System.out.println("The exam has ended. Auto-submitting answers...");
            autoSubmitExam();
        }
    }

    private void autoSubmitExam() {

        System.out.println("Exam auto-submitted at: " + LocalDateTime.now());
        // Call service to save the exam results and calculate scores
        // e.g., scoreService.calculateTotalScore(userId);
    }
}
