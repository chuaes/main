package seedu.giatros.model.appointment;

import static java.util.Objects.requireNonNull;
import static seedu.giatros.commons.util.AppUtil.checkArgument;

import java.time.DayOfWeek;


public class Appointment {
    // TODO make sure that the regex stuff below is correct.
    public static final String MESSAGE_CONSTRAINTS = "Appointment should not be blank and should be in the format: yyyy/MM/dd HH:mm:ss";
    public static final String DAY = "";
    public static final String TIME = "";
    // TODO have a flexible regex
    public static final String VALIDATION_REGEX = "";
    // TODO use day of week object and convert date to day
    // ? should it be final if appointment is editable?
    public String day;
    public String time;
    public final String appointment;
    // TODO make a date field.
    // TODO make it figure out day from the time.


    public Appointment(String appointment){
        requireNonNull(appointment);
        checkArgument(isValidAppointment(appointment), MESSAGE_CONSTRAINTS);
        this.appointment= appointment;
        this.day = day;
        this.time = time;
    }

    // TODO move parser to the ParserUtil class
    public void parseAppointment(String appointment){
        String[] appointmentArray = appointment.split("\\s+");
        day = appointmentArray[0].trim();
        time = appointmentArray[1].trim();
    }

    // TODO extract date time and day.

    public static boolean isValidAppointment(String test){
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Appointment // instanceof handles nulls
                && appointment.equals(((Appointment) other).appointment)); // state check
    }

    @Override
    public int hashCode() {
        return appointment.hashCode();
    }

    public String toString() {
        return appointment;
    }
}


