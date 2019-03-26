package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.GmailLoginPage;
import pages.GmailMainPage;
import pages.GmailPasswordPage;

public class MyStepdefs {

    @Given("^I Logged into the gmail account$")
    public void iOpenedLogInPage() {
        new GmailLoginPage().pressSignInButton().fillEmailIInput().pressNextButton();
        new GmailPasswordPage().fillGmailPasswordInput().pressPasswordNextButton();
    }

    @When("^I Compose new email$")
    public void iComposeNewEmail() {
        new GmailMainPage().pressComposeButton()
                .fillRecipientInput()
                .fillSubjectInput()
                .fillBodyInput();
    }

    @And("^I Close email$")
    public void iCloseThisEmail() {
        new GmailMainPage().saveAndCloseEmail();
    }

    @And("^I send email from Drafts$")
    public void iSendWEmailFromDrafrs() {
        new GmailMainPage().clickOnDraftsLink().clickOnDraftEmail().sendEmail();
    }

    @Then("^I see that this email is saved in drafts$")
    public void iSeeThatThisEmailIsSavedInDrafts() {
        Assert.assertTrue(new GmailMainPage().isEmailAppearedInDrafts());
    }

    @And("^I open Sent folder$")
    public void iOpenSentFolder() {
        new GmailMainPage().clickOnSentLink();
    }

    @Then("^I see that this email appeared in Sent folder$")
    public void iSeeThatThisEmailAppearedInSentFolder() {
        Assert.assertTrue(new GmailMainPage().isEmailAppearedInSentFolder());
    }

    @And("^I open Drafts$")
    public void iOpenDrafts() {
        new GmailMainPage().clickOnDraftsLink();
    }
}

