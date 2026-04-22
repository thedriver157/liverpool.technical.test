package com.liverpool.Interfaces;

import org.openqa.selenium.WebDriver;

public interface IDriverStrategy {
    void initDriver();
    WebDriver getDriver();
}