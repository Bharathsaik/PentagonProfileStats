package org.pentagonprofilestats.testCases;

import org.pentagonprofilestats.pageObjects.PPSHomePageObjects;
import org.pentagonprofilestats.testBase.BaseTestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PPS04TestCaseWebsitesDeveloped extends BaseTestCase {

    PPSHomePageObjects homeObj;

    @BeforeClass
    public void initialize(){
        homeObj = getPPPHomePageObjects();
    }

    @Test(priority = 1 ,dataProvider = "websitesDevelopedDataProvider", dataProviderClass = org.pentagonprofilestats.utilities.DataProviders.class)
    public void validateWebsitesDeveloped(String noOfWebsitesDeveloped){
        homeObj.setWebsitesDeveloped(noOfWebsitesDeveloped);
        Assert.assertEquals(homeObj.getWebSitesDeveloped(), noOfWebsitesDeveloped);
    }

    @Test(priority = 2 ,dataProvider = "websitesDevelopedNegativeTestCaseDataProvider", dataProviderClass = org.pentagonprofilestats.utilities.DataProviders.class)
    public void validateNegativeTestCasesOfWebsitesDevelopedField(String noOfWebsitesDeveloped){
        homeObj.setWebsitesDeveloped(noOfWebsitesDeveloped);
        Assert.assertEquals(homeObj.getWebSitesDeveloped(), "", "Should only accept positive numeric value");
    }


}
