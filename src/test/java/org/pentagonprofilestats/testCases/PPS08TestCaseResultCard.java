package org.pentagonprofilestats.testCases;

import org.pentagonprofilestats.basePageObjects.BasePageObjectsUtil;
import org.pentagonprofilestats.pageObjects.PPSHomePageObjects;
import org.pentagonprofilestats.pageObjects.PPSResultDisplayPageObjects;
import org.pentagonprofilestats.testBase.BaseTestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PPS08TestCaseResultCard extends BaseTestCase {

    PPSResultDisplayPageObjects resultObj;
    @BeforeClass
    public void initializeObject(){
        resultObj = getPPSResultDisplayPageObjects();
    }

    @Test
    public void verifyDisplayName(String actualName){
        String displayedName = resultObj.getDisplayedName();
        //write page object for isDisplayed
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultObj.isNameDisplayed(), "Name not displayed on Result card");
        Assert.assertEquals(displayedName, actualName, "Displayed Name is not same as Actual Name");
    }
    @Test
    public void verifyCupIcon(){
        Assert.assertTrue(resultObj.isCupIconDisplayed(), "Cup Icon not displayed on Result Card");
    }

    @Test
    public void verifyCategory(String category){
        Assert.assertTrue(resultObj.isCatergoryDisplayed(), "catergory not displayed on Result Card");
    }

    @Test
    public void verifyStar(){
        Assert.assertTrue(resultObj.isStarsDisplayed(), "Stars not displayed on Result Card");
    }
    @Test
    public void verifyCaption(){
        Assert.assertTrue(resultObj.isCaptionDisplayed(), "Caption not displayed on Result Card");
    }
}
