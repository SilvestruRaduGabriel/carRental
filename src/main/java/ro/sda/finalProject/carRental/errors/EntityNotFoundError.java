package ro.sda.finalProject.carRental.errors;

public class EntityNotFoundError extends RuntimeException {
    public EntityNotFoundError(String message) {
        super(message);
    }
}
