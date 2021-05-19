#Application Setup
Environment variables to set up on the server:
- PARTNER_DATASOURCE_URL e.g. 'jdbc:mysql://localhost/partner?serverTimezone=UTC'
- PARTNER_KEY e.g. 'secret'
- SPRING_DATASOURCE_USERNAME
- SPRING_DATASOURCE_PASSWORD

#Application Endpoints
1. GET /getEvents
- expects no input
- send back a list of events with their basic details

2. GET /getEvent
- expects an event id as path variable (long)
- returns a list of seat of the event

3. POST /reserve
- expects an event id (long) and a seat id (string)
- returns a success status and a reservation id 

#Other
- application runs on port 8080


