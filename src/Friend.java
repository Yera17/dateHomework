import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Friend {
    private String name;
    private LocalDate birthDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d LLL y", Locale.of("ru"));


    public Friend(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Friend() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name.substring(0,1).toUpperCase()+name.substring(1)
                + " - " + birthDate.format(formatter);
    }

    public void daysBeforeBirthday(){
        LocalDate biDay = birthDate;
        LocalDate nextBiDay = LocalDate.of(LocalDate.now().getYear(), biDay.getMonth(), biDay.getDayOfMonth());
        if (nextBiDay.isBefore(LocalDate.now())) {
            nextBiDay = LocalDate.of(LocalDate.now().getYear()+1, biDay.getMonth(), biDay.getDayOfMonth());
        }

        long days = ChronoUnit.DAYS.between(LocalDate.now(), nextBiDay);
        int yearsOld = Period.between(biDay, LocalDate.now()).getYears();
        System.out.printf("Осталось %d дней. Исполнится %d\n", days, yearsOld+1);
    }
}
