package main;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name="LoginCredentialsProvider")
    public Object[][] getLoginCredentialsDataProvider() {
        return new Object[][] {
                {"mngr230255", "AbUzuhA"},
                {"xxx", "umujuqA"},
                {"mngr215270", "xxx"},
                {"xxx", "xxx"}
        };
    }
}
