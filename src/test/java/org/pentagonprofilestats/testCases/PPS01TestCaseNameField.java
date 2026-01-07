package org.pentagonprofilestats.testCases;

import org.openqa.selenium.Alert;
import org.pentagonprofilestats.pageObjects.PPSHomePageObjects;
import org.pentagonprofilestats.testBase.BaseTestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PPS01TestCaseNameField extends BaseTestCase {

    PPSHomePageObjects homeObj;
    @BeforeClass
    public void initializeObject(){
        homeObj = getPPPHomePageObjects();
    }

    @Test(priority = 1 ,dataProvider = "validNamesDataProvider",
            dataProviderClass = org.pentagonprofilestats.utilities.DataProviders.class)
    public void validName(String userName){
        homeObj.setUserName(userName);
        Assert.assertEquals(homeObj.getUserName(), userName);
    }

    @Test(priority = 2,dataProvider = "EmptyNameDataProvider",
            dataProviderClass = org.pentagonprofilestats.utilities.DataProviders.class)
    public void emptyName(String name, String experience, String skills,
                          String websitesDeveloped, String appsMade) throws InterruptedException {
        homeObj.setUserName(name)
                .setYearsOfExperience(experience)
                .setSkills(skills)
                .setWebsitesDeveloped(websitesDeveloped)
                .setAppsMade(appsMade)
                .clickTrack();
        Alert nameRequiredAlert = homeObj.switchToAlert();
        String alertMessage = nameRequiredAlert.getText();
        nameRequiredAlert.accept();
        Assert.assertEquals(alertMessage,"Name required!");
    }


}
