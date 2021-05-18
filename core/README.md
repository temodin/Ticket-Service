#Application Setup
Environment variables to set up on the server:
- CORE_DATASOURCE_URL
- PARTNER_API_URL
- PARTNER_KEY
- SPRING_DATASOURCE_USERNAME
- SPRING_DATASOURCE_PASSWORD
- SPRING_LOGLEVEL

#Application Endpoints
1. GET /getEvents
- expects no input
- send back a list of events with their basic details

2. GET /getEvent
- expects an event id as path variable (long)
- returns a list of seat of the event

3. POST /reserve
- expects an event id (long), a seat id (string) and a card id (string)
- returns a success status and a reservation id / error code 

#Other
- application runs on port 8081


