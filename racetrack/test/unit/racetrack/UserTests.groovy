package racetrack

import grails.test.*

class UserTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSimpleConstraints() {

     //With invalid input
     mockForConstraintsTests(User)
     def user = new User(login:"someone", password:"blah", role:"SuperUser")
     assertFalse user.validate()
     assertEquals "inList", user.errors["role"]

     //With valid inputs
     mockForConstraintsTests(User)
     user = new User(login:"User1", password:"user", role:"user")
     assertTrue user.validate()
    }
}
