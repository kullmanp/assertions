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

