## Introduction
Tests a
## Problems
- "marketingConsent" is saved always false for new users.
- Can't change "marketingConsent" for new users.
- Migrated users are not converted to Uppercase(data in db should be in same format).
- Can set marketingConsent to customer/customerIDs that don't exist.
- Add new customer data doesn't validate request body - Acceptance criteria.
- There seems to be excess and undocumented info in API doc - 400 is undocumented, 
401 Unauthorized - requests are not behind authorization.

##Notes
Depending on what purpose is customer info saved, it is reasonable to set a unique field for customer data,
so duplicate data is not saved. At the moment there's not enough info about this and randomly generated info
  is not needed for testing.
  
##Assignment 3
Customer service is not release ready, because of some major issues.
A main problem is that marketingConsent is not changed and/or saved correctly.
Also, "Create a new customer" service input data is not validated and new customer 
can be saved with missing data. According to acceptance criteria customer must have firstname, lastname, 
email and also a marketing consent. 
If manager is asking this in the morning, it is possible, that developers have time to fix these issues 
and testing is done before release date. This must be discussed with developers how long fixes will 
take and is this deadline realistic (must consider that new fixes and testing is needed).