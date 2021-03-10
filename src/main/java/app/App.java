package app;

import Pages.ReportCollector;
import Pages.LoginPage;
import Pages.Navigation;

public class App {
    public Navigation navigation;
    public ReportCollector reportCollector;
    public LoginPage loginProcessor;

    public App(){
        loginProcessor = new LoginPage();
        navigation = new Navigation();
        reportCollector = new ReportCollector();
    }
}
