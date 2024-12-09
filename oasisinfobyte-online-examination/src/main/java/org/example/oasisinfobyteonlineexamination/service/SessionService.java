package org.example.oasisinfobyteonlineexamination.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    public void closeSession(HttpSession session) {
        if (session != null) {
            session.invalidate();
            System.out.println("Session closed successfully.");
        }
    }
    public void startSession(HttpSession session, Long userId) {
        // Store user ID in the session to track the user
        session.setAttribute("userId", userId);

        // You can also add other session attributes such as exam start time, or exam status
        session.setAttribute("examStartTime", System.currentTimeMillis());
        session.setAttribute("examDuration", 60 * 60 * 1000); // 1 hour in milliseconds

        System.out.println("Session started for user ID: " + userId);
    }
}
