# Cornucopia


App which aims to reduce food waste and reliably help charities to provide meals to whoever needs them.

Cornucopia gathers data from tens of businesses on food products which are going to expire soon, and organizes them so that non-profits and private citizens can request particular items and retrieve them (for the private citizens, with the option to do so directly at the business which offers the product or at the address of one of the subscribing charities).


TO IMPLEMENT

---Site pages---

- Home

- Report

- Explore and request items

- Login

- Create new account


---Accounts---

(encrypted passwords!!)

1) admins

2) recipients (nonprofits or private citizens)

3) food donors


---Report abuse / bad food---


---Dynamo DB Tables---

1) accounts (id (different among types); name; type (1,2,3); email; password; address (nonprofits, privates); phone number (nonprofits, donors); Optional: link to site (nonprofits,donors);
2) available food (product id; product name; ingredients (set); allergens
3) messages reporting bad food, illegal/toxic/inappropriate events (sender id; object; area of concern; description; status)

---Terms and conditions---

- I won't sell the food, I will just consume it or give it to someone in need

- (Clients) I will execute rigorous checks to ensure that the food I donate is safe for consumption and not deteriorated in an unacceptable way


If something does not work, restore the original order of dependencies in the pom!
