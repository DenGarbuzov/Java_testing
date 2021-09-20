package Pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate (String day, String month, String year){

        String selector = ".react-datepicker__day--%2s";
        String formatedSelector = String.format(selector, day);

        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(formatedSelector).click();}
}
