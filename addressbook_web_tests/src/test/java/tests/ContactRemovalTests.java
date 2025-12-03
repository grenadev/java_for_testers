package tests;

import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    void removeContact() {
        if (!app.contact().isContactPresent()) {
            app.contact().createContact(new ContactData("", "Ivan", "Popov", "88005553555", ""));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contact().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    void removeContactFromGroup() {
        var contact = new ContactData()
                .withFirstName("ТЕСТ АВАТАР")
                .withLastName(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        var oldContacts = app.hbm().getContactsInGroup(group);
        var index = oldContacts.size();
        app.contact().removeContactFromGroup(oldContacts.get(index));



//        var oldRelated = app.hbm().getContactsInGroup(group);
//        app.contact().createContact(contact, group);
//        var newRelated = app.hbm().getContactsInGroup(group);
//        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());

    }
}
