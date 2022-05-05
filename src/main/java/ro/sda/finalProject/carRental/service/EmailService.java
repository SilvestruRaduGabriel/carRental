package ro.sda.finalProject.carRental.service;

@FunctionalInterface
public interface EmailService {
    void sendEmail(String to, String from, String subject, String notes);
}
