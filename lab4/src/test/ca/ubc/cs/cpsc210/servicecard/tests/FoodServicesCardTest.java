package ca.ubc.cs.cpsc210.servicecard.tests;

import ca.ubc.cs.cpsc210.servicecard.model.FoodServicesCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for FoodServiceCard class
class FoodServicesCardTest {
    FoodServicesCard f;

    @BeforeEach
    // construct a card with balance 0
    public void setup() {
        f = new FoodServicesCard(0);
    }

    @Test
    // REQUIRES: initialBalance >= 0
    // EFFECTS: constructs food service card with given initial balance in cents and zero reward points
    public void foodServicesCardTest() {
        assertEquals(0, f.getBalance());
        assertEquals(0, f.getRewardPoints());
    }

    @Test
    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: adds amount cents to balance on card
    public void reloadTest() {

        assertEquals(0, f.getBalance());

        f.reload(1000);
        assertEquals(1000, f.getBalance());

        f.reload(1);
        assertEquals(1001, f.getBalance());
    }

    @Test
    // MODIFIES: this
    // EFFECTS: if there is sufficient balance on the account
    //            - subtracts amount cents from balance
    //            - adds reward points and then
    //                - if eligible, adds cash back reward(s) to account and deducts corresponding reward points
    //            - returns true
    //          otherwise, returns false
    public void makePurchaseTest() {
        assertEquals(0, f.getBalance());      // check to make sure balance is 0
        assertEquals(0, f.getRewardPoints()); // check to make sure points are 0

        f.reload(100);
        f.makePurchase(50);
        assertEquals(50, f.getBalance());

        int rewards = f.getRewardPoints();
        assertEquals(rewards, f.getRewardPoints());
        f.makePurchase(50);

        int rewards2 = f.getRewardPoints();
        assertEquals(0, f.getBalance());
        assertEquals(rewards2, f.getRewardPoints());

        f.reload(1000); // add 100 dollars
        f.makePurchase(5);
        int rewards3 = f.getRewardPoints();
        assertEquals(995, f.getBalance());
        assertEquals(rewards3, f.getRewardPoints());

        // CASES WHERE IT RETURNS TRUE AND FALSE

        f.makePurchase(995);
        assertEquals(0, f.getBalance());  // balance is now 0

        f.reload(10000); // balance = $100
        assertFalse(f.makePurchase(20000)); //amount is WAY too much
        assertTrue(f.makePurchase(10000));  // card can afford this

    }

    @Test
    // EFFECTS: returns remaining balance in cents
    public void getBalanceTest() {
        assertEquals(0, f.getBalance());

        f.reload(10000);

        assertEquals(10000, f.getBalance());
    }
}