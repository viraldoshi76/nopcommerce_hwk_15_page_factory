package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotebooksPage extends Utility {

    private static final Logger log = LogManager.getLogger(NotebooksPage.class.getName());

    @FindBy(xpath = "//div[@class='page-title']")
    WebElement notebookText;

    public String navigateToNotebooksPageSuccessfully(){
        log.info("getting text from notebook page "+ notebookText.toString());
        return getTextFromElement(notebookText);
    }

}
