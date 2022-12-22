import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private LocalDateTime validationTime;
    private Duration durationTime;

    public Ticket(LocalDateTime validationTime, Duration durationTime) {
        this.validationTime = validationTime;
        this.durationTime = durationTime;
    }

    public LocalDateTime getValidationTime() {
        return validationTime;
    }

    public void setValidationTime(LocalDateTime validationTime) {
        this.validationTime = validationTime;
    }

    public Duration getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Duration durationTime) {
        this.durationTime = durationTime;
    }
}
