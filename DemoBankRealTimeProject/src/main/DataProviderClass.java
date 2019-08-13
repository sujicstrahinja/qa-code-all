package main;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name="LoginCredentialsProvider")
    public Object[][] getLoginCredentialsDataProvider() {
        return new Object[][] {
                {"mngr215270", "umujuqA"},
                {"xxx", "umujuqA"},
                {"mngr215270", "xxx"},
                {"xxx", "xxx"}
        };
    }
}
