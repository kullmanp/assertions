# Assertions 
Open X-Day presentation on assertions and the libraries assertJ and hamcrest in particular.

## Intro

General test structure:
- setup 
- do something with the system
- verify that the result is as expected

Example: contact service, add contact
- create and add contact "Maria Muster"
- verify the contact list contains "Maria Muster"

The example could look like this in real code:
```
contactService.add(new Contact("Maria", "Muster");

contacts = contactService.getContacts();
assertNotNull(contacts);
assertEquals(4, contacts.size());
mm = contacts.get(2);
assertEquals("Muster", mm.getName());
assertEquals("Maria", mm.getFirstName());
```                                      

The example shows many problems
- lot of code for a simple statement "list contains ..."
- code is technical, null checks 
- some magic numbers (list size 4, our contact at index 2) that are probably due
to the test setup and are brittle (a different implementation of the service could
place the new contact at a diffeent index)
- assertEquals: difficult to remember which is the expected argument and which is not

Alternatives:
```
assertThat(contactService.getContacts(), hasItem(new Contact("Maria", "Muster")));
```

- Looks more or less like the natural language specification of the test
- Tests only what we want (and not some technical stuff like number of elements)


## Using an assertion library

Assertion libraries (eg. hamcrest or AssertJ) provide a rich set of assertions that can make 
the test code more readable and provide better error messages. They are a substitute for the 
"built-in" assertions like assertTrue, assertEquals, ...

The general idea of the assertion libraries is that of a _matcher_. When we want to verify 
something about the system we can get an object and test whether it matches some matcher. 

Examples of matchers (from hamcrest.org):
- `equalTo`  -- uses the equals method, eg `assertThat(aString, equalTo("hello"))` 
- `instanceOf`, eg. `assertThat(aString, is(instanceOf(String.class)))`  (`is` is just syntactic sugar)
- `greaterThan`, eg. `assertThat(aNumber, is(greaterThan(9.5)))`
- `hasItem` -- checks whether a collection contains a specific item, eg `assertThat(listOfStrings, hasItem("tiger))` 

The really cool thing about matchers is that they are composable:
- `allOf` -- makes a logical and of two matchers, eg `assertThat(aSring, allOf(startsWith("<"), endsWith(">")))`
- `hasItem` again -- the item to be found can be a matcher itself, eg `assertThat(listOfStrings, hasItem(hasLength(11)))` 


## Using hamcrest

## Writing a hamcrest matcher

A matcher does two things:
- actually matching a value (say whether the value matches)
- describe what went wrong when a value does not match


## Kinds of matches - different libraries

- Hamcrest 
- AssertJ
- Mockito 

### Interop between matcher libraries
- AssertJ can use hamcrest matcher with `matching(<hamcrest-matcher>)`
- Mockito supports hamcrest matchers as argument matchers with `argThat(<hamcres-matcher>)`
- Junit 4 supports hamcrest directly (shipped with junit), can use AssertJ additionally
- Junit 5 supports nothing directly. Both hamcrest and AssertJ are suitable.
 


## TDD

Expressive tests make failures clear. Extend the TDD cycle:
- Write failing test
- Make diagnostics clear
- Make the test pass
- Refactor


## Sources
- Growing Object-Oriented Software, Guided by Tests, by Nat Pryce; Steve Freeman
Published by Addison-Wesley Professional, 2009
- https://assertj.github.io/doc/
- http://hamcrest.org/
- https://site.mockito.org/