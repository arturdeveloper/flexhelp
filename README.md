# FlexHelp
Implementation of freelance marketplace idea. There are two type of Users of this application: Providers (freelancers) who sell their services and Customers, - who buy services. Consequently any web-site visitor can choose to register either as a Provider or Customer. After registering and logging on the web-site the navbar changes to reflect the name of currently logged-in user with links(buttons) to Dashboard and to Logout.

Customers don't need to register to view listings of services. They only need to register when they are ready to buy a service. The Dashboard for a Customer shows transactions history for all the services that were purchased. To buy a service Customer needs to login, select an item from the listings that will take to details view for that item, and click on "Complete Purchase" button.

Providers need to register and are redirected to a Dashboard where they can input service description they wish to offer on the Marketplace. After saving the new service it will be added to the listing for Customers to purchase and will also show in the Dashboard area among the "listed items". From here Provider can update the listed item or delete it.

Marketplace allows to select categories of services or filter down services based on location and price.

# Technical Features
Front end technologies: Boostrap, HTML, CSS, JavaScript and jQuery.
Backend: Spring MVC, JPA, MySQL (or MariaDB). Database tables are created automatically once pointed to the correct Database.
The site also includes validation with Hibernate-validator, sessions, routing based on Id, redirects for clean links and testing with jUnit.

Some of technical challenges faced had to do with general design of the application, most parts were re-written to reflect better understanding of the framework and to better take advantage of its facilities. Among particular challenges were figuring out how to maintain session and validation errors during redirects. These features are dependent on framework and it is not obvious how to pass these objects between different routes. Another complication arose when doing queries with JPA. In some cases preference was given to using Lambdas to filter results and achieve the design goal.
Some of the approaches used to tackle technical challenges: debugging, printing out variable values to console to narrow down the cause of problem, trying methods with different signatures, tesing ideas on smaller-scale prototypes.

# Some screenshots
![](/screenshots/front_page.png)
![](/screenshots/registration.png)
![](/screenshots/customer_dashboard.png)
![](/screenshots/provider_dashboard.png)