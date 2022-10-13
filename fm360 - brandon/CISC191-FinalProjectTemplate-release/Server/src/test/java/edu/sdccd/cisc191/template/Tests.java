package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Tests {

    // example arrays for testing
    ModelGameBoard modelGameBoard;
    ControllerGameBoard controllerGameBoard;

    /**
     * Sets up the test fixture with some arrays to test.
     * This method is called before every test case method.
     */
    @BeforeAll
    public void setUp() {
        controllerGameBoard = new ControllerGameBoard();
        modelGameBoard = new ModelGameBoard();

    }



}