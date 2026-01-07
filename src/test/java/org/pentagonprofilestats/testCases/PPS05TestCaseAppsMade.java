package org.pentagonprofilestats.testCases;

import org.pentagonprofilestats.pageObjects.PPSHomePageObjects;
import org.pentagonprofilestats.testBase.BaseTestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PPS05TestCaseAppsMade extends BaseTestCase {

    PPSHomePageObjects homeObj;

    @BeforeClass
    public void initialize(){
        homeObj = getPPPHomePageObjects();
    }

    @Test(priority = 1 ,dataProvider = "appsMadeDataProvider", dataProviderClass = org.pentagonprofilestats.utilities.DataProviders.class)
    public void validateAppsMade(String noOfAppsMade){
        homeObj.setAppsMade(noOfAppsMade);
        Assert.assertEquals(homeObj.getAppsMade(), noOfAppsMade);
    }

    @Test(priority = 2 ,dataProvider = "appsMadeNegativeTestCaseDataProvider", dataProviderClass = org.pentagonprofilestats.utilities.DataProviders.class)
    public void validateNegativeTestCasesOfAppsMadeField(String noOfAppsMade){
        homeObj.setAppsMade(noOfAppsMade);
        Assert.assertEquals(homeObj.getAppsMade(), "", "Should only accept positive numeric value");
    }

}
