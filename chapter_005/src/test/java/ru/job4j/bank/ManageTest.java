package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Test Manage.
 */
public class ManageTest {
    /**
     * Test add user.
     */
    @Test
    public void addUserToHashMap() {
        User user = new User("Sergey", "123");
        Manage manage = new Manage();
        Map dep = manage.getDep();
        manage.addUser(user);
        boolean result = dep.containsKey(user);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    /**
     * Test del user.
     */
    @Test
    public void delUserFromHashMap() {
        User user = new User("Sergey", "123");
        Manage manage = new Manage();
        Map dep = manage.getDep();
        manage.addUser(user);
        manage.deleteUser(user);
        boolean result = dep.containsKey(user);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    /**
     * Test add account to user.
     */
    @Test
    public void addAccountToUserInHashmap() {
        User user = new User("Sergey", "123");
        Manage manage = new Manage();
        Account account = new Account(100, 1773);
        Account account1 = new Account(150, 2001);
        Map<User, List<Account>> dep = manage.getDep();
        manage.addUser(user);
        manage.addAccountToUser(user, account);
        manage.addAccountToUser(user, account1);
        String result = "";
        for (Map.Entry<User, List<Account>> userListEntry : dep.entrySet()) {
            result = (userListEntry.getValue().toString());
        }
        String expected = "[Account{value=100.0, requisites=1773}, Account{value=150.0, requisites=2001}]";
        assertThat(result, is(expected));
    }

    /**
     * Test del account from List<Account>.
     */
    @Test
    public void delAccountFromListAccount() {
        User user = new User("Sergey", "123");
        Manage manage = new Manage();
        Account accountFirst = new Account(100, 1773);
        Account accountSecond = new Account(100, 2000);
        Account accountThird = new Account(100, 1500);
        Map<User, List<Account>> dep = manage.getDep();
        List<Account> listAccountsTest = new ArrayList<Account>();
        manage.addUser(user);
        manage.addAccountToUser(user, accountFirst);
        manage.addAccountToUser(user, accountSecond);
        manage.addAccountToUser(user, accountThird);
        for (Map.Entry<User, List<Account>> entry : dep.entrySet()) {
            if (entry.getKey().equals(user)) {
                listAccountsTest = entry.getValue();
            }
        }
        manage.deleteAccountFromUser(user, accountSecond);
        boolean result = listAccountsTest.contains(accountSecond);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    /**
     * Return all account for selected users.
     */
    @Test
    public void returnListAllAccountsFromSpecifiedUser() {
        User user = new User("Sergey", "123");
        Manage manage = new Manage();
        Account accountFirst = new Account(100, 1773);
        Account accountSecond = new Account(100, 2000);
        Map<User, List<Account>> dep = manage.getDep();
        List<Account> expected = new ArrayList<Account>();
        manage.addUser(user);
        manage.addAccountToUser(user, accountFirst);
        manage.addAccountToUser(user, accountSecond);
        List<Account> result = manage.getUserAccounts(user);
        expected.add(accountFirst);
        expected.add(accountSecond);
        assertEquals(result, expected);
    }

    /**
     * Successful transfer money from one user to another.
     */
    @Test
    public void successfulTransferMoneyFromOneUserToAnother() {
        User user = new User("Sergey", "123");
        User user1 = new User("Andrey", "321");
        Manage manage = new Manage();
        Account accountFirst = new Account(100, 1773);
        Account accountSecond = new Account(100, 2000);
        Account accountThird = new Account(100, 2001);
        Account accountFourth = new Account(100, 1234);
        manage.addUser(user);
        manage.addUser(user1);
        manage.addAccountToUser(user, accountFirst);
        manage.addAccountToUser(user, accountSecond);
        manage.addAccountToUser(user1, accountThird);
        manage.addAccountToUser(user1, accountFourth);
        boolean result = manage.transferMoney(user, accountSecond, user1, accountThird, 50);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    /**
     * Unsuccessful transfer money from one user to another.
     */
    @Test
    public void unsuccessfulTransferMoneyFromOneUserToAnother() {
        User user = new User("Sergey", "123");
        User user1 = new User("Andrey", "321");
        Manage manage = new Manage();
        Account accountFirst = new Account(100, 1773);
        Account accountSecond = new Account(100, 2000);
        Account accountThird = new Account(100, 2001);
        Account accountFourth = new Account(100, 1234);
        manage.addUser(user);
        manage.addUser(user1);
        manage.addAccountToUser(user, accountFirst);
        manage.addAccountToUser(user, accountSecond);
        manage.addAccountToUser(user1, accountThird);
        manage.addAccountToUser(user1, accountFourth);
        boolean result = manage.transferMoney(user, accountSecond, user1, accountThird, 200);
        boolean expected = false;
        assertThat(result, is(expected));
    }
}
