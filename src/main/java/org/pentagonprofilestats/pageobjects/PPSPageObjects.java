package org.pentagonprofilestats.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PPSPageObjects {
    WebDriver driver;
    private final WebDriverWait wait;
    public PPSPageObjects(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="name")
    WebElement userName;

    @FindBy(id="experience")
    WebElement yearsOfExperience;

    @FindBy(id="skills")
    WebElement skills;

    @FindBy(id="websites")
    WebElement websitesDeveloped;

    @FindBy(id="apps")
    WebElement appsMade;

    @FindBy(id="measureBtn")
    WebElement trackButton;

    public void setUserName(String userName){
        wait.until(ExpectedConditions.elementToBeClickable(this.userName));
        this.userName.clear();
        this.userName.sendKeys(userName);

    }

    public void setYearsOfExperience(String yearsOfExperience){
        wait.until(ExpectedConditions.visibilityOf(this.yearsOfExperience));
        Select select = new Select(this.yearsOfExperience);
        select.selectByVisibleText(yearsOfExperience);
    }

    public void setSkills(String commaSeparatedSkills){
        String[] tokens = commaSeparatedSkills.split(",");
        for (String skill : tokens) {
            String trimmedSkill = skill.trim();
            wait.until(ExpectedConditions.elementToBeClickable(skills));
            skills.clear();
            skills.sendKeys(trimmedSkill);
            By suggestionLocator = By.xpath("//div[@id='suggestionsList']//div[text()='" + trimmedSkill + "']");
            WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(suggestionLocator));
            suggestion.click();
        }
    }

    public void setWebsitesDeveloped(int websitesDeveloped){
        wait.until(ExpectedConditions.elementToBeClickable(this.websitesDeveloped));
        this.websitesDeveloped.clear();
        this.websitesDeveloped.sendKeys(String.valueOf(websitesDeveloped));
    }

    public void setAppsMade(int appsMade){
        wait.until(ExpectedConditions.elementToBeClickable(this.appsMade));
        this.appsMade.clear();
        this.appsMade.sendKeys(String.valueOf(appsMade));
    }


    public void clickTrack(){
        wait.until(ExpectedConditions.elementToBeClickable(trackButton)).click();
    }




}
